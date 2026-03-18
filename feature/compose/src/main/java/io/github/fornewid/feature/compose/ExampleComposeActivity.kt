package io.github.fornewid.feature.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import io.github.fornewid.core.compose.ExampleTheme
import io.github.fornewid.core.kotlin.injector
import io.github.fornewid.feature.bar.Bar
import javax.inject.Inject

class ExampleComposeActivity : ComponentActivity() {

    @Inject
    lateinit var bar: Bar

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as ComposeInjector).inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            ExampleTheme {
                Column {
                    // Option 1
                    StateHoisting.Screen(bar = bar)

                    // Option 2
                    CompositionLocal.Screen(bar = bar)

                    // Option 3
                    InjectorEntryPoints.Screen()
                }
            }
        }
    }
}

/**
 * https://developer.android.com/jetpack/compose/state#state-hoisting
 */
object StateHoisting {

    @Composable
    fun Screen(bar: Bar) {
        GrandParents(bar = bar)
    }

    @Composable
    private fun GrandParents(bar: Bar) {
        Parents(bar = bar)
    }

    @Composable
    private fun Parents(bar: Bar) {
        Children(bar = bar)
    }

    @Composable
    private fun Children(bar: Bar) {
        GrandChildren(bar = bar)
    }

    @Composable
    private fun GrandChildren(bar: Bar) {
        // Use bar
        Text(text = bar.toString())
    }
}

/**
 * https://developer.android.com/jetpack/compose/compositionlocal
 */
object CompositionLocal {

    @Composable
    fun Screen(bar: Bar) {
        CompositionLocalProvider(LocalBar provides bar) {
            GrandParents()
        }
    }

    @Composable
    private fun GrandParents() {
        Parents()
    }

    @Composable
    private fun Parents() {
        Children()
    }

    @Composable
    private fun Children() {
        GrandChildren()
    }

    @Composable
    private fun GrandChildren() {
        // Use bar
        val bar: Bar = LocalBar.current
        Text(text = bar.toString())
    }

    private val LocalBar = staticCompositionLocalOf<Bar> {
        error("CompositionLocal LocalBar not present")
    }
}

/**
 * Access dependencies via the injector from any Composable.
 */
object InjectorEntryPoints {

    interface BarProvider {
        fun bar(): Bar
    }

    @Composable
    fun Screen() {
        GrandParents()
    }

    @Composable
    private fun GrandParents() {
        Parents()
    }

    @Composable
    private fun Parents() {
        Children()
    }

    @Composable
    private fun Children() {
        GrandChildren()
    }

    @Composable
    private fun GrandChildren() {
        // Use bar
        val bar: Bar = rememberBar()
        Text(text = bar.toString())
    }

    @Composable
    private fun rememberBar(): Bar {
        val context = LocalContext.current
        return remember {
            (context.injector as BarProvider).bar()
        }
    }
}
