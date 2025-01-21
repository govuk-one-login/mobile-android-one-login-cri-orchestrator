import com.android.build.api.dsl.ApplicationExtension
import uk.gov.onelogin.criorchestrator.extensions.configureEnvironmentFlavors
import uk.gov.onelogin.criorchestrator.extensions.setApplicationId

plugins {
    id("uk.gov.onelogin.criorchestrator.android-app-config")
}

configure<ApplicationExtension> {
    setApplicationId(suffix = ".testwrapper")
    configureEnvironmentFlavors()
}

private val stagingImplementation by project.configurations

dependencies {
    listOf(
        libs.gov.logging.testdouble,
    ).forEach {
        androidTestImplementation(it)
    }

    listOf(
        libs.firebase.analytics,
        libs.firebase.crashlytics,
        libs.dagger.hilt.gradle,
        libs.google.services,
        libs.gov.logging.api,
        libs.gov.logging.testdouble,
        libs.hilt.android,
        libs.uk.gov.networking,
        project(":sdk:public-api"),
        project(":sdk:shared-api"),
        platform(libs.firebase.bom),
    ).forEach {
        implementation(it)
    }

    listOf(
        libs.gov.logging.testdouble,
        platform(libs.org.junit.bom),
    ).forEach(::testImplementation)
}
