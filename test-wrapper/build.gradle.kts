import com.android.build.api.dsl.ApplicationExtension
import uk.gov.onelogin.criorchestrator.extensions.configureEnvironmentFlavors
import uk.gov.onelogin.criorchestrator.extensions.setApplicationId

plugins {
    id("uk.gov.onelogin.criorchestrator.android-app-config")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

configure<ApplicationExtension> {
    setApplicationId(suffix = ".testwrapper")
    configureEnvironmentFlavors()
}

dependencies {
    listOf(
        libs.gov.logging.testdouble,
    ).forEach {
        androidTestImplementation(it)
    }

    listOf(
        libs.firebase.analytics,
        libs.firebase.crashlytics,
        libs.gov.logging.api,
        libs.gov.logging.impl,
        libs.gov.logging.testdouble,
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
