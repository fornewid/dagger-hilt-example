package io.github.fornewid.feature.navigation.fragment.bindings

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.injector
import io.github.fornewid.feature.navigation.fragment.R
import javax.inject.Inject

class ExampleNavigationFragmentActivity : FragmentActivity(R.layout.example_nav_graph_activity) {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as NavigationFragmentInjector).inject(this)
        super.onCreate(savedInstanceState)
    }
}
