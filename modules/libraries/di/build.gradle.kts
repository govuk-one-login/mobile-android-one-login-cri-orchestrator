plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ksp)
}

java {
    sourceCompatibility = JavaVersion.toVersion(17)
    targetCompatibility = JavaVersion.toVersion(17)
}

dependencies {
    implementation(libs.dagger)
    implementation(libs.dagger.compiler)
}
