package io.github.fornewid.core.kotlin.di

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * ViewModel that holds the ActivityRetainedComponent.
 * Since ViewModel survives configuration changes, the component does too.
 * This is how Hilt's ActivityRetainedComponent works internally.
 */
class ActivityRetainedComponentHolder : ViewModel() {
    var component: ActivityRetainedComponent? = null
}

/**
 * Extension property to get or create the ActivityRetainedComponent.
 *
 * On first access, creates the component via the factory from AppComponent.
 * On subsequent accesses (including after config change), returns the same instance.
 */
val ComponentActivity.activityRetainedComponent: ActivityRetainedComponent
    get() {
        val holder = ViewModelProvider(this)[ActivityRetainedComponentHolder::class.java]
        return holder.component ?: run {
            val factory = (applicationContext as ComponentProvider)
                .activityRetainedComponentFactory()
            factory.create().also { holder.component = it }
        }
    }
