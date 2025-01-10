package uk.gov.onelogin.criorchestrator

import com.android.build.api.dsl.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import uk.gov.onelogin.criorchestrator.extensions.androidTestDependencies
import uk.gov.onelogin.criorchestrator.extensions.setJavaVersion
import uk.gov.onelogin.criorchestrator.extensions.testDependencies
import uk.gov.onelogin.criorchestrator.extensions.uiDependencies

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    "uk.gov.pipelines.android-lib-config"
).forEach {
    project.plugins.apply(it)
}

configure<LibraryExtension>{
    setJavaVersion()
}

configure<KotlinAndroidProjectExtension> {
    setJavaVersion()
}

dependencies{
    androidTestDependencies(libs)
    testDependencies(libs)
    uiDependencies(libs)
}

listOf(
    libs.plugins.android.library,
    libs.plugins.kotlin.android,
).forEach {
    project.plugins.apply(it.get().pluginId)
}