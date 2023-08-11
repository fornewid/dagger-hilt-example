package io.github.fornewid.data

import io.github.fornewid.core.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ExampleRepository {
    suspend fun getSomething(): String
}

internal class ExampleRepositoryImpl @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : ExampleRepository {

    override suspend fun getSomething(): String {
        return withContext(ioDispatcher) {
            delay(500)
            "something"
        }
    }
}
