plugins {
    id("uk.gov.onelogin.criorchestrator.android-lib-config")
    id("uk.gov.onelogin.criorchestrator.base-compose-config")
    id("uk.gov.onelogin.criorchestrator.local-ui-test-config")

    alias(libs.plugins.kotlin.serialization)
}

dependencies {
    api(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.collections.immutable)

    testImplementation(libs.androidx.compose.material3)
    testImplementation(libs.kotlinx.serialization.json)
}
