package io.github.fornewid.dagger.hilt.example

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.fragment.app.Fragment

val Context.appComponent: AppComponent
    get() = (applicationContext as ExampleApplication).appComponent

val Activity.appComponent: AppComponent
    get() = (application as ExampleApplication).appComponent

val Fragment.appComponent: AppComponent
    get() = (requireActivity().application as ExampleApplication).appComponent

val View.appComponent: AppComponent
    get() {
        var ctx = context
        while (ctx is ContextWrapper) {
            if (ctx is ExampleApplication) return ctx.appComponent
            ctx = ctx.baseContext
        }
        return (context.applicationContext as ExampleApplication).appComponent
    }
