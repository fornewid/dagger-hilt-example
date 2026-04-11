package io.github.fornewid.core.kotlin.di

import com.squareup.anvil.annotations.ContributesSubcomponent

/**
 * Per-ViewModel subcomponent.
 *
 * Each ViewModel instance gets its own ViewModelComponent,
 * allowing @ViewModelScoped bindings to be unique per ViewModel.
 *
 * Hierarchy: AppComponent → ActivityRetainedComponent → ViewModelComponent
 */
@ViewModelScoped
@ContributesSubcomponent(
    scope = ViewModelScope::class,
    parentScope = ActivityRetainedScope::class,
)
interface ViewModelComponent {

    @ContributesSubcomponent.Factory
    interface Factory {
        fun create(): ViewModelComponent
    }
}
