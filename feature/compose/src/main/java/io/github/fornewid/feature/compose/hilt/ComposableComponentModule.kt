package io.github.fornewid.feature.compose.hilt

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import io.github.fornewid.core.kotlin.AppScope

@Module(subcomponents = [ComposableComponent::class])
@ContributesTo(AppScope::class)
interface ComposableComponentModule
