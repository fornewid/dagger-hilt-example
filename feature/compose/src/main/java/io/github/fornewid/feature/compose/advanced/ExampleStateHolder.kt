package io.github.fornewid.feature.compose.advanced

import io.github.fornewid.feature.bar.Bar
import io.github.fornewid.feature.compose.hilt.ComposableScoped
import javax.inject.Inject

@ComposableScoped
class ExampleStateHolder @Inject constructor(
    val bar: Bar,
) {
    override fun toString(): String {
        return "ExampleStateHolder@" + hashCode().toString(16)
    }
}
