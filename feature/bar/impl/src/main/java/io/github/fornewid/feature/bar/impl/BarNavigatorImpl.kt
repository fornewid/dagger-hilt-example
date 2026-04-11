package io.github.fornewid.feature.bar.impl

import android.content.Context
import android.content.Intent
import com.squareup.anvil.annotations.ContributesBinding
import io.github.fornewid.core.kotlin.di.AppScope
import io.github.fornewid.feature.bar.BarNavigator
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class BarNavigatorImpl @Inject constructor() : BarNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, BarActivity::class.java)
    }
}
