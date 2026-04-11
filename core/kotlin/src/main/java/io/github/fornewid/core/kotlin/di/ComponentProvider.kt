package io.github.fornewid.core.kotlin.di

/**
 * Interface that Application implements to expose the ActivityRetainedComponent factory.
 * Feature modules use this to create/retrieve the retained component
 * without depending on the :app module.
 */
interface ComponentProvider {
    fun activityRetainedComponentFactory(): ActivityRetainedComponent.Factory
}
