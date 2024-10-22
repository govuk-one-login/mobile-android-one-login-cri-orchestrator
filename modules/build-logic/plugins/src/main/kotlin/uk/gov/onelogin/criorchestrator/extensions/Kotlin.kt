package uk.gov.onelogin.criorchestrator.extensions

import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun KotlinAndroidProjectExtension.setJavaVersion() {
    jvmToolchain(JAVA_VERSION)
}
