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
        libs.androidx.fragment.ktx,
        libs.firebase.analytics,
        libs.firebase.crashlytics,
        libs.dagger.hilt.gradle,
        libs.gov.logging.api,
        libs.gov.logging.impl,
        libs.gov.logging.testdouble,
        libs.hilt.android,
        libs.uk.gov.networking,
        libs.uk.gov.onelogin.idcheck.features.api,
        libs.androidx.lifecycle.viewmodel.compose,
        project(":modules:sdk:public-api"),
        project(":modules:sdk:shared-api"),
        platform(libs.firebase.bom),
    ).forEach {
        implementation(it)
    }

    listOf(
        libs.gov.logging.testdouble,
        platform(libs.org.junit.bom),
    ).forEach(::testImplementation)
}
