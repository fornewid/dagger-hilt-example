import com.squareup.anvil.plugin.AnvilExtension
import io.github.fornewid.dagger.hilt.buildlogic.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidAnvilConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.squareup.anvil")
            }

            extensions.configure<AnvilExtension> {
                generateDaggerFactories.set(true)
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                implementation(libs.findLibrary("dagger").get())
                implementation(libs.findLibrary("anvil.annotations").get())
                implementation(libs.findLibrary("anvil.annotations.optional").get())
            }
        }
    }
}
