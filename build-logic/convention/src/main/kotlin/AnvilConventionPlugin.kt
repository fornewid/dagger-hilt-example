import com.squareup.anvil.plugin.AnvilExtension
import io.github.fornewid.dagger.hilt.buildlogic.implementation
import io.github.fornewid.dagger.hilt.buildlogic.ksp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AnvilConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dev.zacsweers.anvil")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<AnvilExtension> {
                useKsp(
                    contributesAndFactoryGeneration = true,
                    componentMerging = true,
                )
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                implementation(libs.findLibrary("anvil.annotations").get())
                ksp(libs.findLibrary("anvil.compiler").get())
            }
        }
    }
}
