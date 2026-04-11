package io.github.fornewid.core.kotlin.di

/**
 * Anvil scope marker for the per-ViewModel subcomponent.
 * Replaces Hilt's ViewModelComponent.
 *
 * Each ViewModel instance gets its own ViewModelComponent,
 * so @ViewModelScoped bindings are unique per ViewModel.
 */
abstract class ViewModelScope private constructor()
