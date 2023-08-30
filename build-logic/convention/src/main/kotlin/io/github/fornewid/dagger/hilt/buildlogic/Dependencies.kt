package io.github.fornewid.dagger.hilt.buildlogic

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? {
    return add("kapt", dependencyNotation)
}

fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? {
    return add("ksp", dependencyNotation)
}

fun DependencyHandler.findProject(
    path: String,
    configuration: String? = null,
): Dependency {
    return project(
        mapOf(
            "path" to path,
            "configuration" to configuration,
        ).filterValues { it != null }
    )
}
