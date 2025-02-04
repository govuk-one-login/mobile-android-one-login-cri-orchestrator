plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
    ).forEach {
        id(it)
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
}
