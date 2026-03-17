package io.github.fornewid.feature.work.bindings

import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.work.ExampleTasks
import io.github.fornewid.feature.work.impl.ExampleUseCase
import io.github.fornewid.feature.work.impl.ExampleUseCaseImpl

@Module
@ContributesTo(AppScope::class)
interface TasksModule {

    @Binds
    fun bindsExampleTasks(impl: ExampleTasksImpl): ExampleTasks

    @Binds
    fun bindsExampleUseCase(impl: ExampleUseCaseImpl): ExampleUseCase
}
