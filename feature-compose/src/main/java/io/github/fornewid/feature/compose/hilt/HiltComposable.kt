package io.github.fornewid.feature.compose.hilt

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import dagger.hilt.EntryPoints

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

@Composable
fun rememberComposableComponentManager(): ComposableComponentManager {
    val context = LocalContext.current
    val compositionContext = rememberCompositionContext()
    return remember(context, compositionContext) {
        ComposableComponentManager(context = context, compositionContext = compositionContext)
    }
}

val LocalComponentManager = staticCompositionLocalOf<ComposableComponentManager> {
    error("CompositionLocal LocalComponentManager not present")
}

@Composable
fun <T> fromComposable(entryPoint: Class<T>): T {
    val component = LocalComponentManager.current
    return EntryPoints.get(component, entryPoint)
}
