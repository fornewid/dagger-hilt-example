package io.github.fornewid.feature.foo.impl

import android.content.Context
import android.content.Intent
import io.github.fornewid.feature.foo.FooNavigator
import javax.inject.Inject

class FooNavigatorImpl @Inject constructor() : FooNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, FooActivity::class.java)
    }
}
