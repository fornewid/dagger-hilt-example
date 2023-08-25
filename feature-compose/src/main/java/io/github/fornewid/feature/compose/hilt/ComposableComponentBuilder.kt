package io.github.fornewid.feature.compose.hilt

import androidx.compose.runtime.CompositionContext
import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface ComposableComponentBuilder {
    fun compositionContext(@BindsInstance context: CompositionContext): ComposableComponentBuilder
    fun build(): ComposableComponent
}
