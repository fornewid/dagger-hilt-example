package io.github.fornewid.core.kotlin.di

import com.squareup.anvil.annotations.ContributesSubcomponent

/**
 * Subcomponent that survives configuration changes.
 *
 * @ContributesSubcomponent tells Anvil to:
 * 1. Generate a @Subcomponent with all modules contributed to ActivityRetainedScope
 * 2. Automatically wire the Factory into the parent (AppScope) component
 *
 * The parent AppComponent will have access to this Factory
 * without any manual @Module(subcomponents = [...]) wiring.
 */
@ActivityRetainedScoped
@ContributesSubcomponent(
    scope = ActivityRetainedScope::class,
    parentScope = AppScope::class,
)
interface ActivityRetainedComponent {

    fun viewModelFactory(): ViewModelFactory

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): ActivityRetainedComponent
    }
}
