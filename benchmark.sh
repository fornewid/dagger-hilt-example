#!/bin/bash
# Build performance benchmark script
# Runs each test case 30 times and collects timing data

set -e

ITERATIONS=30
RESULTS_DIR="benchmark_results"
mkdir -p "$RESULTS_DIR"

# File paths for modifications
FOO_IMPL="feature/foo/impl/src/main/java/io/github/fornewid/feature/foo/impl/FooImpl.kt"
FOO_API="feature/foo/api/src/main/java/io/github/fornewid/feature/foo/Foo.kt"
FOO_MODULE="feature/foo/bindings/src/main/java/io/github/fornewid/feature/foo/bindings/FooModule.kt"

echo "========================================="
echo " Build Performance Benchmark"
echo " Iterations per test: $ITERATIONS"
echo "========================================="

# Function to run benchmark
run_benchmark() {
    local test_name="$1"
    local touch_file="$2"
    local output_file="$RESULTS_DIR/${test_name}.txt"

    echo ""
    echo "--- Test Case $test_name ---"
    echo "Touch file: $touch_file"

    # Warm up (2 runs, discard)
    for i in 1 2; do
        touch "$touch_file"
        ./gradlew assembleDevDebug --quiet 2>/dev/null
    done

    > "$output_file"

    for i in $(seq 1 $ITERATIONS); do
        touch "$touch_file"
        # Use --quiet and capture only timing
        start_ms=$(python3 -c "import time; print(int(time.time()*1000))")
        ./gradlew assembleDevDebug --quiet 2>/dev/null
        end_ms=$(python3 -c "import time; print(int(time.time()*1000))")
        elapsed=$((end_ms - start_ms))
        echo "$elapsed" >> "$output_file"
        printf "  Run %2d/%d: %d ms\n" "$i" "$ITERATIONS" "$elapsed"
    done

    echo ""
    echo "Results for $test_name:"
    python3 -c "
import sys
data = sorted([int(x.strip()) for x in open('$output_file') if x.strip()])
n = len(data)
median = data[n//2] if n%2 else (data[n//2-1]+data[n//2])//2
p90_idx = int(n * 0.9)
p90 = data[min(p90_idx, n-1)]
mean = sum(data)//n
print(f'  Count:  {n}')
print(f'  Median: {median} ms')
print(f'  P90:    {p90} ms')
print(f'  Mean:   {mean} ms')
print(f'  Min:    {data[0]} ms')
print(f'  Max:    {data[-1]} ms')
"
}

# Test Case A: impl 내부 수정 (Non-ABI) - 가장 빈번한 일상 개발
run_benchmark "A_impl_nonabi" "$FOO_IMPL"

# Test Case B: 인터페이스 수정 (ABI 변경)
run_benchmark "B_api_abi" "$FOO_API"

# Test Case C: bindings 모듈 수정 (DI wiring 변경)
run_benchmark "C_bindings_module" "$FOO_MODULE"

echo ""
echo "========================================="
echo " SUMMARY"
echo "========================================="

python3 -c "
import os

tests = ['A_impl_nonabi', 'B_api_abi', 'C_bindings_module']
labels = ['A: impl Non-ABI', 'B: API ABI Change', 'C: Bindings Module']

print(f'{\"Test Case\":<25} {\"Median\":>10} {\"P90\":>10} {\"Mean\":>10}')
print('-' * 60)

for test, label in zip(tests, labels):
    path = f'benchmark_results/{test}.txt'
    if os.path.exists(path):
        data = sorted([int(x.strip()) for x in open(path) if x.strip()])
        n = len(data)
        median = data[n//2] if n%2 else (data[n//2-1]+data[n//2])//2
        p90_idx = int(n * 0.9)
        p90 = data[min(p90_idx, n-1)]
        mean = sum(data)//n
        print(f'{label:<25} {median:>8} ms {p90:>8} ms {mean:>8} ms')
"
