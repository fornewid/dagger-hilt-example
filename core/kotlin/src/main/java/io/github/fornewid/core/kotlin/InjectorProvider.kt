package io.github.fornewid.core.kotlin

import android.content.Context

interface InjectorProvider {
    val injector: Any
}

val Context.injector: Any
    get() = (applicationContext as InjectorProvider).injector
