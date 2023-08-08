package io.github.fornewid.feature.work.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.fornewid.feature.work.ExampleTasks

@Module
@InstallIn(SingletonComponent::class)
interface TasksModule {

    @Binds
    fun bindsExampleTasks(impl: ExampleTasksImpl): ExampleTasks

    @Binds
    fun bindsExampleUseCase(impl: ExampleUseCaseImpl): ExampleUseCase
}
