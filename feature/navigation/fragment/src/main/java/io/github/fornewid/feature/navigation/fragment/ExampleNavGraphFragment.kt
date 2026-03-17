package io.github.fornewid.feature.navigation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.injector
import javax.inject.Inject

class ExampleNavGraphFragment : Fragment(R.layout.example_nav_graph_fragment) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private val viewModel: ExampleNavGraphViewModel by navGraphViewModels(R.id.nav_graph) { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireContext().injector as NavigationFragmentInjector).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.doSomething()
    }
}
