package io.github.fornewid.feature.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleNavigationFragmentActivity : FragmentActivity(R.layout.example_nav_graph_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
