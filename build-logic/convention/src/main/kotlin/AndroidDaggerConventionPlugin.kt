import io.github.fornewid.dagger.hilt.buildlogic.implementation
import io.github.fornewid.dagger.hilt.buildlogic.ksp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidDaggerConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                implementation(libs.findLibrary("dagger.core").get())
                ksp(libs.findLibrary("dagger.compiler").get())
            }
        }
    }
}
