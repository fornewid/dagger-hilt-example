package io.github.fornewid.feature.navigation.compose.bindings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.fornewid.core.compose.ExampleTheme
import io.github.fornewid.core.kotlin.DaggerViewModelFactory
import io.github.fornewid.core.kotlin.injector
import io.github.fornewid.feature.navigation.compose.ExampleNavGraph
import javax.inject.Inject

class ExampleNavigationComposeActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as NavigationComposeInjector).inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                ExampleNavGraph(viewModelFactory = viewModelFactory)
            }
        }
    }
}
