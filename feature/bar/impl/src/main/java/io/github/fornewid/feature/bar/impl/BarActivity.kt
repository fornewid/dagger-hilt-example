package io.github.fornewid.feature.bar.impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import io.github.fornewid.core.kotlin.di.activityRetainedComponent

class BarActivity : ComponentActivity(R.layout.bar_activity) {

    private val viewModel: BarViewModel by viewModels {
        activityRetainedComponent.viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.doSomething()
    }
}
