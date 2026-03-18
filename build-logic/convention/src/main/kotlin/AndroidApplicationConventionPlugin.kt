import io.github.fornewid.dagger.hilt.buildlogic.configureAndroid
import io.github.fornewid.dagger.hilt.buildlogic.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            configureAndroid()
            configureKotlin()
        }
    }
}
