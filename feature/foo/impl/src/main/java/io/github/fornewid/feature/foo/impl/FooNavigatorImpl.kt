package io.github.fornewid.feature.foo.impl

import android.content.Context
import android.content.Intent
import com.squareup.anvil.annotations.ContributesBinding
import io.github.fornewid.core.kotlin.di.AppScope
import io.github.fornewid.feature.foo.FooNavigator
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class FooNavigatorImpl @Inject constructor() : FooNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, FooActivity::class.java)
    }
}
