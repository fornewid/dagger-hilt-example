package io.github.fornewid.feature.navigation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ExampleScreen(
    screenName: String,
    viewModel: ExampleNavGraphViewModel,
    onClick: (() -> Unit)? = null,
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = screenName)
            Text(text = viewModel.getSomething(), color = Color.Red)
            if (onClick != null) {
                Button(onClick = onClick) {
                    Text(text = "Go to next!")
                }
            }
        }
    }
}
