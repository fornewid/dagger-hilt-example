package io.github.fornewid.core.kotlin.di

/**
 * Anvil scope marker for the application-level component.
 * Replaces Hilt's SingletonComponent.
 *
 * Modules annotated with @ContributesTo(AppScope::class) or
 * bindings annotated with @ContributesBinding(AppScope::class)
 * will be automatically included in the @MergeComponent(AppScope::class).
 */
abstract class AppScope private constructor()
