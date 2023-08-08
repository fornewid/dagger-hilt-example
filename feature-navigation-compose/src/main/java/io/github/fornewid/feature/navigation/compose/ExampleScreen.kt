package io.github.fornewid.feature.navigation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExampleScreen(viewModel: ExampleNavGraphViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.doSomething()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello World!",
            modifier = Modifier.align(Alignment.Center),
        )
    }
}
