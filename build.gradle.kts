// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("uk.gov.pipelines.android-root-config")
}

buildscript {
    val buildLogicDir: String by extra("mobile-android-pipelines/buildLogic")
}
