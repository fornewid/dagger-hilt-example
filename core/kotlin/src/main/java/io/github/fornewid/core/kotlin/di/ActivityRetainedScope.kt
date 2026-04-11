package io.github.fornewid.core.kotlin.di

/**
 * Anvil scope marker for the activity-retained-level subcomponent.
 * Replaces Hilt's ActivityRetainedComponent.
 *
 * Modules contributed to this scope survive configuration changes
 * because the component is held in a ViewModel.
 */
abstract class ActivityRetainedScope private constructor()
