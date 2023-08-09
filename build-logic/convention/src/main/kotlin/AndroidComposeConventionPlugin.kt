import io.github.fornewid.dagger.hilt.buildlogic.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            configureCompose()
        }
    }
}
