package io.github.fornewid.feature.compose.bindings.hilt

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope
import io.github.fornewid.feature.compose.hilt.ComposableComponent

@Module(subcomponents = [ComposableComponent::class])
@ContributesTo(AppScope::class)
interface ComposableComponentModule
