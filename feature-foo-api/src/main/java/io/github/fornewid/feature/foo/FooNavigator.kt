package io.github.fornewid.feature.foo

import android.content.Context
import android.content.Intent

interface FooNavigator {
    fun createIntent(context: Context): Intent
}
