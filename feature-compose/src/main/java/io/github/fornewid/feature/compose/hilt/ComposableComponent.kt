package io.github.fornewid.feature.compose.hilt

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ActivityComponent

@ComposableScoped
@DefineComponent(parent = ActivityComponent::class)
interface ComposableComponent
