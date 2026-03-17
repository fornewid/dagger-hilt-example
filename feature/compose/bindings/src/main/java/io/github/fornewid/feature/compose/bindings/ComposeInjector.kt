package io.github.fornewid.feature.compose.bindings

import io.github.fornewid.feature.compose.bindings.advanced.AdvancedExampleComposeActivity

interface ComposeInjector {
    fun inject(activity: ExampleComposeActivity)
    fun inject(activity: AdvancedExampleComposeActivity)
}
