package io.github.fornewid.feature.work.impl

import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import io.github.fornewid.feature.work.ExampleTasks
import javax.inject.Inject

class ExampleTasksImpl @Inject constructor(
    private val workManager: WorkManager,
) : ExampleTasks {

    override fun executeExampleTask() {
        workManager.enqueue(OneTimeWorkRequestBuilder<ExampleWorker>().build())
    }
}
