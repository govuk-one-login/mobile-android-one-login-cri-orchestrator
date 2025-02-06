plugins {
    id("uk.gov.onelogin.criorchestrator.android-lib-config")
    id("uk.gov.onelogin.criorchestrator.base-compose-config")
}

dependencies {
    // Enable screenshot tests to be generated from composable previews
    testFixturesApi(libs.composable.preview.scanner)
    testFixturesApi(libs.google.testparameterinjector)
    // Paparazzi tests only support Junit 4
    testFixturesApi(platform(libs.org.junit.bom))
    testFixturesApi(libs.org.junit.junit4)

    testFixturesImplementation(platform(libs.androidx.compose.bom))
    testFixturesImplementation(libs.androidx.compose.runtime)
    testFixturesImplementation(libs.androidx.lifecycle.viewmodel.compose)

    testFixturesCompileOnly(libs.app.cash.paparazzi)
}
