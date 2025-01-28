import com.android.build.api.dsl.ApplicationExtension
import uk.gov.onelogin.criorchestrator.extensions.configureEnvironmentFlavors
import uk.gov.onelogin.criorchestrator.extensions.setApplicationId

plugins {
    id("uk.gov.onelogin.criorchestrator.android-app-config")
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.google.services)
}

configure<ApplicationExtension> {
    setApplicationId(suffix = ".testwrapper")
    configureEnvironmentFlavors()
}

dependencies {
    listOf(
        libs.firebase.analytics,
        libs.firebase.crashlytics,
        libs.uk.gov.logging.api,
        libs.uk.gov.logging.impl,
        libs.uk.gov.networking,
        project(":sdk:public-api"),
        project(":sdk:shared-api"),
        platform(libs.firebase.bom),
    ).forEach {
        implementation(it)
    }

    listOf(
        platform(libs.org.junit.bom),
    ).forEach(::testImplementation)
}
