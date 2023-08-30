package io.github.fornewid.feature.compose.advanced

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import io.github.fornewid.core.compose.ExampleTheme
import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.compose.hilt.ComposableComponent
import io.github.fornewid.feature.compose.hilt.ComposableScoped
import io.github.fornewid.feature.compose.hilt.ComposeEntryPointAccessors
import io.github.fornewid.feature.compose.hilt.HiltComposable
import javax.inject.Inject

@AndroidEntryPoint
class AdvancedExampleComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
        val entryPoint = ComposeEntryPointAccessors.fromComposable(ExampleEntryPoint::class.java)
        return remember {
            entryPoint.exampleStateHolder()
        }
    }
}

@EntryPoint
@InstallIn(ComposableComponent::class)
interface ExampleEntryPoint {
    fun exampleStateHolder(): ExampleStateHolder
}

@ComposableScoped
class ExampleStateHolder @Inject constructor(
    val bar: Bar,
) {
    override fun toString(): String {
        return "ExampleStateHolder@" + hashCode().toString(16)
    }
}
