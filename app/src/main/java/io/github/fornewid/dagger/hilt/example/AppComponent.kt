package io.github.fornewid.dagger.hilt.example

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.DaggerWorkerFactory
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.bar.impl.BarInjector
import io.github.fornewid.feature.compose.ComposeInjector
import io.github.fornewid.feature.compose.InjectorEntryPoints
import io.github.fornewid.feature.compose.hilt.ComposableComponentFactoryProvider
import io.github.fornewid.feature.foo.impl.FooInjector
import io.github.fornewid.feature.navigation.compose.NavigationComposeInjector
import io.github.fornewid.feature.navigation.fragment.NavigationFragmentInjector
import javax.inject.Singleton

@MergeComponent(AppScope::class)
@Singleton
interface AppComponent :
    FooInjector,
    BarInjector,
    NavigationComposeInjector,
    NavigationFragmentInjector,
    ComposeInjector,
    ComposableComponentFactoryProvider,
    InjectorEntryPoints.BarProvider {

    fun viewModelFactory(): DaggerViewModelFactory
    fun workerFactory(): DaggerWorkerFactory
    override fun bar(): Bar

    fun inject(activity: ExampleActivity)
    fun inject(fragment: ExampleFragment)
    fun inject(service: ExampleService)
    fun inject(service: ExampleLifecycleService)
    fun inject(receiver: ExampleBroadcastReceiver)
    fun inject(view: ExampleView)

    @MergeComponent.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
