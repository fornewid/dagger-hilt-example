plugins {
    `kotlin-dsl`
}

group = "io.github.fornewid.dagger.hilt.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    compileOnly(libs.android.pluginGradle)
    compileOnly(libs.kotlin.pluginGradle)
    compileOnly(libs.anvil.pluginGradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "example.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "example.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidAnvil") {
            id = "example.android.anvil"
            implementationClass = "AndroidAnvilConventionPlugin"
        }
    }
}
