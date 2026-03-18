package io.github.fornewid.dagger.hilt.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureAndroid() {
    val android = extensions.getByName("android") as CommonExtension<*, *, *, *, *, *>
    android.compileSdk = Versions.compileSdk
    android.defaultConfig.minSdk = Versions.minSdk
    android.compileOptions.sourceCompatibility = JavaVersion.VERSION_17
    android.compileOptions.targetCompatibility = JavaVersion.VERSION_17
}
