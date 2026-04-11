package io.github.fornewid.core.kotlin.di

import javax.inject.Scope

/**
 * Dagger scope annotation for bindings scoped to a single ViewModel's lifetime.
 * Each ViewModel gets its own ViewModelComponent instance.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelScoped
