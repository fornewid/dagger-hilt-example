package io.github.fornewid.dagger.hilt.buildlogic

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    android {
        buildFeatures.compose = true
        composeOptions {
            kotlinCompilerExtensionVersion = libs.findVersion("compose-compiler").get().toString()
        }
    }
    dependencies {
        implementation(platform(libs.findLibrary("compose-bom").get()))
    }
}

private fun Project.android(action: BaseExtension.() -> Unit) {
    extensions.configure(action)
}
