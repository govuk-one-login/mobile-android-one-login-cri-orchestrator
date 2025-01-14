plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("privateRepositories") {
            id = "uk.gov.onelogin.criorchestrator.settings.private-repositories"
            implementationClass = "uk.gov.onelogin.criorchestrator.settings.PrivateRepositoriesPlugin"
        }
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    implementation(libs.uk.gov.pipelines.plugins)
    implementation(libs.android.build.tool)
    implementation(libs.kotlin.gradle.plugin)

    //https://github.com/gradle/gradle/issues/15383
    implementation(files((libs as Any).javaClass.superclass.protectionDomain.codeSource.location))
}