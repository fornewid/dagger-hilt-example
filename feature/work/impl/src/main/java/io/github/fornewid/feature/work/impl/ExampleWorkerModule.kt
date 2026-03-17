package io.github.fornewid.feature.work.impl

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.WorkerAssistedFactory
import io.github.fornewid.core.kotlin.WorkerKey

@Module
@ContributesTo(AppScope::class)
object ExampleWorkerModule {

    @Provides
    @IntoMap
    @WorkerKey("io.github.fornewid.feature.work.impl.ExampleWorker")
    fun provideExampleWorkerFactory(factory: ExampleWorker.Factory): WorkerAssistedFactory {
        return object : WorkerAssistedFactory {
            override fun create(context: Context, workerParameters: WorkerParameters): ListenableWorker {
                return factory.create(context, workerParameters)
            }
        }
    }
}
