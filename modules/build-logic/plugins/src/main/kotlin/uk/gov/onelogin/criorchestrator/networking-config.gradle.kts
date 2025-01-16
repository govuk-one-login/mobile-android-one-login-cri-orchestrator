package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.networkingDependencies

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

dependencies {
    networkingDependencies(libs)
}