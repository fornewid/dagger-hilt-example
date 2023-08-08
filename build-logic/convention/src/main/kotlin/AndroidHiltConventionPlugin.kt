import io.github.fornewid.dagger.hilt.buildlogic.implementation
import io.github.fornewid.dagger.hilt.buildlogic.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                implementation(libs.findLibrary("dagger.hilt.android").get())
                kapt(libs.findLibrary("dagger.hilt.compiler").get())
            }
        }
    }
}
