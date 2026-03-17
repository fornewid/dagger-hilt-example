package io.github.fornewid.feature.work.impl

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.work.ExampleTasks

@Module
@ContributesTo(AppScope::class)
interface TasksModule {

    @Binds
    fun bindsExampleTasks(impl: ExampleTasksImpl): ExampleTasks

    @Binds
    fun bindsExampleUseCase(impl: ExampleUseCaseImpl): ExampleUseCase
}
