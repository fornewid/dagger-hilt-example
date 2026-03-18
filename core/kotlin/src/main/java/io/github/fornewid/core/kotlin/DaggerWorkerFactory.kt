package io.github.fornewid.core.kotlin

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class DaggerWorkerFactory @Inject constructor(
    private val workerFactories: Map<String, @JvmSuppressWildcards Provider<WorkerAssistedFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters,
    ): ListenableWorker? {
        val factoryProvider = workerFactories[workerClassName] ?: return null
        return factoryProvider.get().create(appContext, workerParameters)
    }
}

interface WorkerAssistedFactory {
    fun create(context: Context, workerParameters: WorkerParameters): ListenableWorker
}
