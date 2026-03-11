package io.github.fornewid.feature.navigation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleNavGraphFragment : Fragment(R.layout.example_nav_graph_fragment) {

    private val viewModel: ExampleNavGraphViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doSomething()
    }
}
