package io.github.fornewid.data

import io.github.fornewid.core.kotlin.IoDispatcher
import io.github.fornewid.dagger.hilt.example.buildconfig.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ExampleRepository {
    suspend fun getSomething(): String
}

class ExampleRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ExampleRepository {

    override suspend fun getSomething(): String {
        return withContext(ioDispatcher) {
            delay(500)
            // BuildConfig는 buildconfig-stub(compileOnly)로 컴파일되고,
            // 런타임에는 app이 가져오는 buildconfig 모듈의 실제 값으로 교체됨.
            "something from ${BuildConfig.API_BASE_URL}"
        }
    }
}
