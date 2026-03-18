package io.github.fornewid.dagger.hilt.example

import android.app.Application
import androidx.work.Configuration
import io.github.fornewid.core.kotlin.InjectorProvider

class ExampleApplication : Application(), Configuration.Provider, InjectorProvider {

    val appComponent: AppComponent by lazy {
        DaggerMergedAppComponent.factory().create(this)
    }

    override val injector: Any
        get() = appComponent

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(appComponent.workerFactory())
            .build()
}
