package io.github.fornewid.dagger.hilt.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import javax.inject.Inject

class ExampleFragment : Fragment(R.layout.example_fragment) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private val viewModel: ExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doSomething()
    }
}
