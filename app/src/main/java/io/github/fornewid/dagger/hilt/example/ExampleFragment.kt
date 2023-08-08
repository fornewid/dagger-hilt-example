package io.github.fornewid.dagger.hilt.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleFragment : Fragment(R.layout.example_fragment) {

    private val viewModel: ExampleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doSomething()
    }
}
