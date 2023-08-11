package io.github.fornewid.feature.bar.impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BarActivity : ComponentActivity(R.layout.bar_activity) {

    private val viewModel: BarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.doSomething()
    }
}
