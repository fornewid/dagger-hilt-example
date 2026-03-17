package io.github.fornewid.feature.compose.hilt

import dagger.Subcomponent
import io.github.fornewid.feature.compose.advanced.ExampleStateHolder

@ComposableScoped
@Subcomponent
interface ComposableComponent {

    fun exampleStateHolder(): ExampleStateHolder

    @Subcomponent.Factory
    interface Factory {
        fun create(): ComposableComponent
    }
}
