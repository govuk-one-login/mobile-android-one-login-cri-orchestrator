package uk.gov.onelogin.criorchestrator

import com.android.build.api.dsl.ApplicationExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import uk.gov.onelogin.criorchestrator.extensions.uiDependencies
import org.gradle.accessors.dm.LibrariesForLibs
import uk.gov.onelogin.criorchestrator.extensions.setAndroidSdkVersions
import uk.gov.onelogin.criorchestrator.extensions.androidTestDependencies
import uk.gov.onelogin.criorchestrator.extensions.setBuildTypes
import uk.gov.onelogin.criorchestrator.extensions.setUiConfig
import uk.gov.onelogin.criorchestrator.extensions.ideSupportDependencies
import uk.gov.onelogin.criorchestrator.extensions.setJavaVersion
import uk.gov.onelogin.criorchestrator.extensions.setPackagingConfig
import uk.gov.onelogin.criorchestrator.extensions.testDependencies
import uk.gov.onelogin.criorchestrator.extensions.setTestingConfig

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    libs.plugins.android.application,
    libs.plugins.kotlin.android,
    libs.plugins.compose.compiler,
).forEach {
    project.plugins.apply(it.get().pluginId)
}

configure<ApplicationExtension> {
    setAndroidSdkVersions()
    setTestingConfig()
    setUiConfig()
    setBuildTypes()
    setJavaVersion()
    setUiConfig()
    setPackagingConfig()
}

configure<KotlinAndroidProjectExtension> {
    setJavaVersion()
}

dependencies {
    uiDependencies(libs)
    testDependencies(libs)
    androidTestDependencies(libs)
    ideSupportDependencies(libs)
}
