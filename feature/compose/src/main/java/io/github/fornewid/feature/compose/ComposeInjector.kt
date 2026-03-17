package io.github.fornewid.feature.compose

import io.github.fornewid.feature.compose.advanced.AdvancedExampleComposeActivity

interface ComposeInjector {
    fun inject(activity: ExampleComposeActivity)
    fun inject(activity: AdvancedExampleComposeActivity)
}
