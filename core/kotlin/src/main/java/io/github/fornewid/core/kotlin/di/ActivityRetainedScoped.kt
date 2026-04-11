package io.github.fornewid.core.kotlin.di

import javax.inject.Scope

/**
 * Dagger scope annotation for bindings that should live as long as the
 * ActivityRetainedComponent (survives configuration changes).
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityRetainedScoped
