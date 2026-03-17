package io.github.fornewid.feature.compose.hilt

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import io.github.fornewid.core.kotlin.injector

@Composable
fun HiltComposable(
    content: @Composable () -> Unit
) {
    val component = rememberComposableComponent()
    CompositionLocalProvider(
        LocalComposableComponent provides component,
        content = content,
    )
}

@Composable
fun rememberComposableComponent(): ComposableComponent {
    val context = LocalContext.current
    return remember(context) {
        val factory = (context.injector as ComposableComponentFactoryProvider).composableComponentFactory()
        factory.create()
    }
}

val LocalComposableComponent = staticCompositionLocalOf<ComposableComponent> {
    error("CompositionLocal LocalComposableComponent not present")
}

@Composable
fun rememberComposableEntryPoint(): ComposableComponent {
    return LocalComposableComponent.current
}

/**
 * Implemented by the AppComponent to provide the ComposableComponent.Factory.
 */
interface ComposableComponentFactoryProvider {
    fun composableComponentFactory(): ComposableComponent.Factory
}
