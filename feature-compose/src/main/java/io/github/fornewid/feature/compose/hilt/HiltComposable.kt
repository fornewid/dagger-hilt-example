package io.github.fornewid.feature.compose.hilt

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun HiltComposable(
    content: @Composable () -> Unit
) {
    val componentManager = rememberComposableComponentManager()
    CompositionLocalProvider(
        LocalComponentManager provides componentManager,
        content = content,
    )
}
