package uk.gov.onelogin.criorchestrator.settings

import org.gradle.api.Plugin
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.initialization.Settings
import org.gradle.kotlin.dsl.maven

class PrivateRepositoriesPlugin: Plugin<Settings> {
    override fun apply(target: Settings) {
        target.dependencyResolutionManagement {
            repositories {
                maven(
                    "https://maven.pkg.github.com/govuk-one-login/mobile-android-ui",
                    target.setupGithubCredentials()
                )
            }
        }
    }
}

private fun Settings.setupGithubCredentials(): MavenArtifactRepository.() -> Unit =
    {
        val (credUser, credToken) = fetchGithubCredentials()
        credentials {
            username = credUser
            password = credToken
        }
    }

private fun Settings.fetchGithubCredentials(): Pair<String, String> {
    val gprUser = System.getenv("GITHUB_ACTOR")
    val gprToken = System.getenv("GITHUB_TOKEN")

    if (!gprUser.isNullOrEmpty() && !gprToken.isNullOrEmpty()) {
        return Pair(gprUser, gprToken)
    }

    val gprUserProperty = providers.gradleProperty("gpr.user")
    val gprTokenProperty = providers.gradleProperty("gpr.token")

    return gprUserProperty.get() to gprTokenProperty.get()
}
