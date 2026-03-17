package io.github.fornewid.feature.foo.impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.injector
import javax.inject.Inject

class FooActivity : ComponentActivity(R.layout.foo_activity) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private val viewModel: FooViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as FooInjector).inject(this)
        super.onCreate(savedInstanceState)
        viewModel.doSomething()
    }
}
