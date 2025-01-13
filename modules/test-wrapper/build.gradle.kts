import com.android.build.api.dsl.ApplicationExtension
import uk.gov.onelogin.criorchestrator.extensions.configureEnvironmentFlavors
import uk.gov.onelogin.criorchestrator.extensions.setApplicationId
import uk.gov.onelogin.criorchestrator.extensions.setNamespace
import uk.gov.pipelines.config.ApkConfig

plugins {
    id("uk.gov.onelogin.criorchestrator.android-app-config")
}

configure<ApplicationExtension> {
    setApplicationId(suffix = ".testwrapper")
    setNamespace(suffix = ".testwrapper")
    configureEnvironmentFlavors()
}

val apkConfig by rootProject.extra(
    object: ApkConfig {
        override val applicationId: String = "uk.gov.onelogin.criorchestrator.testwrapper"
        override val debugVersion: String = "DEBUG_VERSION"
        override val sdkVersions = object: ApkConfig.SdkVersions {
            override val minimum = 29
            override val target = 34
            override val compile = 35
        }
    }
)
