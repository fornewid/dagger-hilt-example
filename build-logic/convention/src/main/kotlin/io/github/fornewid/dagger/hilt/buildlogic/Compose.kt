package io.github.fornewid.dagger.hilt.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose() {
    pluginManager.apply("org.jetbrains.kotlin.plugin.compose")
    val android = extensions.getByName("android") as CommonExtension
    android.buildFeatures.compose = true
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        implementation(platform(libs.findLibrary("compose-bom").get()))
    }
}
