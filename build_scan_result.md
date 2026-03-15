# Build Scan Result: 3_bindings (API/Impl/Bindings 분리)

## 모듈 구조

```
┌─────────────────┐       ┌─────────────────┐       ┌──────────────────────────────────────┐
│ feature:foo:api  │ <──── │ feature:foo:impl │ <──── │ feature:foo:bindings                 │
│ ├─ Interface    │ 참조  │ ├─ Logic         │ 참조  │ ├─ DI (@Module, @Binds)              │
│ │               │       │ │               │       │ ├─ Activity (@AndroidEntryPoint)     │
│ (x) KSP 없음    │       │ (x) KSP 없음    │       │ ├─ ViewModel (@HiltViewModel)        │
└─────────────────┘       └─────────────────┘       │ (*) KSP 구동: DI 코드 수정 시에만 발생│
                                                    └──────────────────────────────────────┘
```

- **api**: 인터페이스만 포함. KSP/Hilt 없음.
- **impl**: 순수 구현 클래스만 포함. `@Inject` 생성자만 사용. KSP/Hilt 플러그인 없음.
- **bindings**: `@Module`, `@AndroidEntryPoint`, `@HiltViewModel`, `@HiltWorker` 등 Hilt 어노테이션이 필요한 코드 포함. KSP/Hilt 구동.

핵심 원리: impl 모듈에 KSP가 없으므로, impl 코드 수정 시 KSP annotation processing이 발생하지 않음.

---

## Test Case A: 내부 구현 로직 수정 (Non-ABI 변경)

### 변경 내용
`feature/foo/impl`의 `FooImpl.kt`에 `println()` 한 줄 추가 (메서드 시그니처 변경 없음)

### 빌드 결과
- **총 소요 시간**: 12s
- **실행된 태스크**: 5개 (323개 중)
- **UP-TO-DATE**: 318개

### 실행된 태스크 상세

| 태스크 | 상태 | 설명 |
|--------|------|------|
| `:feature:foo:impl:compileDebugKotlin` | EXECUTED | 변경된 소스 재컴파일 |
| `:feature:foo:impl:bundleLibCompileToJarDebug` | EXECUTED | 컴파일 결과 JAR 패키징 |
| `:feature:foo:impl:bundleLibRuntimeToJarDebug` | EXECUTED | 런타임 JAR 패키징 |
| `:app:mergeLibDexDebug` | EXECUTED | 라이브러리 DEX 병합 |
| `:app:packageDebug` | EXECUTED | APK 패키징 |

### KSP 태스크 상태

| KSP 태스크 | 상태 |
|-----------|------|
| `:feature:foo:bindings:kspDebugKotlin` | **UP-TO-DATE** |
| `:feature:bar:bindings:kspDebugKotlin` | **UP-TO-DATE** |
| `:feature:work:bindings:kspDebugKotlin` | **UP-TO-DATE** |
| `:app:kspDebugKotlin` | **UP-TO-DATE** |
| `:data:kspDebugKotlin` | **UP-TO-DATE** |
| `:core:kotlin:kspDebugKotlin` | **UP-TO-DATE** |

### 핵심 관찰
- impl 모듈의 Non-ABI 변경 시, **어떤 KSP 태스크도 실행되지 않음**
- bindings 모듈의 컴파일/KSP도 완전히 스킵됨
- 변경 영향 범위가 `foo:impl` -> `app` 패키징으로 최소화됨

---

## Test Case B: 인터페이스 수정 (ABI 변경)

### 변경 내용
1. `feature/foo/api`의 `Foo.kt` 인터페이스에 `fun newFeature(): String` 메서드 추가
2. `feature/foo/impl`의 `FooImpl.kt`에 해당 메서드 구현 추가

### 빌드 결과
- **총 소요 시간**: 17s
- **실행된 태스크**: 21개 (323개 중)
- **UP-TO-DATE**: 302개

### 실행된 태스크 상세

| 태스크 | 상태 | 설명 |
|--------|------|------|
| `:feature:foo:api:compileDebugKotlin` | EXECUTED | API 인터페이스 재컴파일 |
| `:feature:foo:api:bundleLibCompileToJarDebug` | EXECUTED | API JAR 패키징 |
| `:feature:foo:api:bundleLibRuntimeToJarDebug` | EXECUTED | API 런타임 JAR 패키징 |
| `:feature:foo:impl:compileDebugKotlin` | EXECUTED | impl 재컴파일 (API 변경 전파) |
| `:feature:foo:impl:bundleLibCompileToJarDebug` | EXECUTED | impl JAR 패키징 |
| `:feature:foo:impl:bundleLibRuntimeToJarDebug` | EXECUTED | impl 런타임 JAR 패키징 |
| `:feature:bar:impl:compileDebugKotlin` | EXECUTED | bar:impl 재컴파일 (foo:api 의존) |
| `:feature:foo:bindings:kspDebugKotlin` | EXECUTED | **KSP 재실행** (impl 변경 전파) |
| `:feature:foo:bindings:compileDebugKotlin` | EXECUTED | bindings 재컴파일 |
| `:feature:foo:bindings:transformDebugClassesWithAsm` | EXECUTED | ASM 변환 |
| `:feature:bar:bindings:kspDebugKotlin` | EXECUTED | **KSP 재실행** (bar:impl 변경 전파) |
| `:feature:bar:bindings:compileDebugKotlin` | EXECUTED | bindings 재컴파일 |
| `:feature:bar:bindings:transformDebugClassesWithAsm` | EXECUTED | ASM 변환 |
| `:app:kspDebugKotlin` | EXECUTED | app KSP 재실행 |
| `:app:compileDebugKotlin` | EXECUTED | app 재컴파일 |
| `:app:hiltSyncDebug` | EXECUTED | Hilt 동기화 |
| `:app:hiltJavaCompileDebug` | EXECUTED | Hilt Java 컴파일 |
| `:app:transformDebugClassesWithAsm` | EXECUTED | ASM 변환 |
| `:app:dexBuilderDebug` | EXECUTED | DEX 빌드 |
| `:app:mergeProjectDexDebug` | EXECUTED | DEX 병합 |
| `:app:packageDebug` | EXECUTED | APK 패키징 |

### KSP 태스크 상태

| KSP 태스크 | 상태 |
|-----------|------|
| `:feature:foo:bindings:kspDebugKotlin` | **EXECUTED** |
| `:feature:bar:bindings:kspDebugKotlin` | **EXECUTED** |
| `:feature:work:bindings:kspDebugKotlin` | UP-TO-DATE |
| `:app:kspDebugKotlin` | **EXECUTED** |
| `:data:kspDebugKotlin` | UP-TO-DATE |
| `:core:kotlin:kspDebugKotlin` | UP-TO-DATE |

### 핵심 관찰
- API 인터페이스 변경은 ABI 변경이므로 의존 모듈 전반에 걸쳐 재컴파일 발생
- foo:api에 의존하는 foo:impl, foo:bindings, bar:impl, bar:bindings, app 모두 영향 받음
- work 모듈은 foo:api에 직접 의존하지 않으므로 영향 없음 (work:bindings KSP UP-TO-DATE)

---

## 요약

| 시나리오 | 실행된 태스크 | KSP 실행 | 빌드 시간 |
|---------|-------------|---------|----------|
| **A: impl 내부 변경** | 5 / 323 | 0개 (전부 UP-TO-DATE) | 12s |
| **B: api 인터페이스 변경** | 21 / 323 | 3개 (foo, bar, app) | 17s |

### 3-module 분리의 효과
- **impl 코드 수정 시 KSP가 완전히 스킵됨** -- 가장 빈번한 일상 개발 시나리오에서 annotation processing 비용 제거
- impl 모듈에는 Hilt 플러그인이 없으므로 KSP 태스크 자체가 존재하지 않음
- bindings 모듈의 입력(classpath)이 변하지 않으면 KSP 캐시가 유효하게 유지됨
- API 변경 시에는 bindings의 KSP도 실행되지만, 이는 인터페이스 변경의 정당한 비용임
