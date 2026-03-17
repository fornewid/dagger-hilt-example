package io.github.fornewid.feature.work.impl

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ExampleWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val example: ExampleUseCase,
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val success = example()
        return if (success) {
            Result.success()
        } else {
            Result.failure()
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(context: Context, workerParams: WorkerParameters): ExampleWorker
    }
}
