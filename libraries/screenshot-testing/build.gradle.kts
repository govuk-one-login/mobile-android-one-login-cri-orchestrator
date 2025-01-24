plugins {
    id("uk.gov.onelogin.criorchestrator.android-lib-config")
    id("uk.gov.onelogin.criorchestrator.base-compose-config")
}

dependencies {
    // Enable screenshot tests to be generated from composable previews
    api(libs.composable.preview.scanner)
    api(libs.google.testparameterinjector)
    // Paparazzi tests only support Junit 4
    api(platform(libs.org.junit.bom))
    api(libs.org.junit.junit4)

    implementation(libs.app.cash.paparazzi)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.runtime)
}
