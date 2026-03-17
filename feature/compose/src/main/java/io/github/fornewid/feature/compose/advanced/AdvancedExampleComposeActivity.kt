package io.github.fornewid.feature.compose.advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import io.github.fornewid.core.compose.ExampleTheme
import io.github.fornewid.core.kotlin.injector
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.compose.ComposeInjector
import io.github.fornewid.feature.compose.hilt.ComposableScoped
import io.github.fornewid.feature.compose.hilt.HiltComposable
import io.github.fornewid.feature.compose.hilt.rememberComposableEntryPoint
import javax.inject.Inject

class AdvancedExampleComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        (injector as ComposeInjector).inject(this)
        super.onCreate(savedInstanceState)

        setContent {
            ExampleTheme {
                HiltComposableScoped.Screen()
            }
        }
    }
}

object HiltComposableScoped {

    @Composable
    fun Screen() {
        HiltComposable {
            GrandParents()
        }
    }

    @Composable
    private fun GrandParents() {
        val stateHolder = rememberStateHolder()
        Column {
            Text(
                text = "GrandParents: $stateHolder",
                color = Color.Red,
            )
            Parents()
        }
    }

    @Composable
    private fun Parents() {
        val stateHolder = rememberStateHolder()
        Column {
            Text(
                text = "Parents: $stateHolder",
                color = Color.Green,
            )
            Children()
        }
    }

    @Composable
    private fun Children() {
        val stateHolder = rememberStateHolder()
        Column {
            Text(
                text = "Children: $stateHolder",
                color = Color.Blue,
            )
            HiltComposable {
                GrandChildren()
            }
        }
    }

    @Composable
    private fun GrandChildren() {
        val stateHolder = rememberStateHolder()
        Text(
            text = "GrandChildren: $stateHolder",
        )
    }

    @Composable
    private fun rememberStateHolder(): ExampleStateHolder {
        val component = rememberComposableEntryPoint()
        return remember {
            component.exampleStateHolder()
        }
    }
}

@ComposableScoped
class ExampleStateHolder @Inject constructor(
    val bar: Bar,
) {
    override fun toString(): String {
        return "ExampleStateHolder@" + hashCode().toString(16)
    }
}
