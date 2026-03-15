package io.github.fornewid.feature.bar.impl

import android.content.Context
import android.content.Intent
import io.github.fornewid.feature.bar.BarNavigator
import javax.inject.Inject

class BarNavigatorImpl @Inject constructor() : BarNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, BarActivity::class.java)
    }
}
