package io.github.fornewid.dagger.hilt.example.di

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import io.github.fornewid.core.kotlin.di.ActivityRetainedComponent
import io.github.fornewid.core.kotlin.di.AppScope
import io.github.fornewid.dagger.hilt.example.ExampleActivity
import javax.inject.Singleton

/**
 * Root Dagger component.
 *
 * @MergeComponent(AppScope::class) tells Anvil to automatically discover and include
 * all modules annotated with @ContributesTo(AppScope::class) and all bindings annotated
 * with @ContributesBinding(AppScope::class) across the entire classpath.
 *
 * @ContributesSubcomponent(parentScope = AppScope) from ActivityRetainedComponent
 * is also automatically wired into this component by Anvil.
 *
 * Component hierarchy:
 *   AppComponent (@Singleton)
 *     └── ActivityRetainedComponent (@ActivityRetainedScoped)
 *           └── ViewModelComponent (@ViewModelScoped)
 */
@Singleton
@MergeComponent(AppScope::class)
interface AppComponent {

    fun activityRetainedComponentFactory(): ActivityRetainedComponent.Factory

    fun inject(activity: ExampleActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
