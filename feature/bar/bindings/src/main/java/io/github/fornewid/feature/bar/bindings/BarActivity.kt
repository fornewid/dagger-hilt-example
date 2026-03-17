package io.github.fornewid.feature.bar.bindings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.injector
import io.github.fornewid.feature.bar.impl.BarViewModel
import javax.inject.Inject

class BarActivity : ComponentActivity(R.layout.bar_activity) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private val viewModel: BarViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as BarInjector).inject(this)
        super.onCreate(savedInstanceState)
        viewModel.doSomething()
    }
}
