package uk.gov.onelogin.criorchestrator

import com.squareup.anvil.plugin.AnvilExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.diDependencies

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    libs.plugins.ksp,
    libs.plugins.anvil,
).forEach {
    project.plugins.apply(it.get().pluginId)
}

configure<AnvilExtension> {
    disableComponentMerging = false
    useKsp(
        contributesAndFactoryGeneration = true,
        componentMerging = true,
    )
}

dependencies {
    diDependencies(libs)
}