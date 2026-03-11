package io.github.fornewid.feature.bar

import android.content.Context
import android.content.Intent

interface BarNavigator {
    fun createIntent(context: Context): Intent
}
