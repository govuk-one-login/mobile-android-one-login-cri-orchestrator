plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    listOf(
        libs.android.build.tool,
        libs.anvil.gradle.plugin,
        libs.kotlin.gradle.plugin,
        libs.uk.gov.pipelines.plugins,
        libs.google.services,
    ).forEach {
        implementation(it)
    }

    //https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}