package io.github.fornewid.dagger.hilt.example

import android.app.Application
import io.github.fornewid.core.kotlin.di.ActivityRetainedComponent
import io.github.fornewid.core.kotlin.di.ComponentProvider
import io.github.fornewid.dagger.hilt.example.di.DaggerAppComponent

class ExampleApplication : Application(), ComponentProvider {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    override fun activityRetainedComponentFactory(): ActivityRetainedComponent.Factory =
        appComponent.activityRetainedComponentFactory()
}
