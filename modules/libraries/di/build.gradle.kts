plugins {
    `java-library`
}

listOf(
    libs.plugins.kotlin.jvm,
    libs.plugins.ksp,
).forEach {
    project.plugins.apply(it.get().pluginId)
}

dependencies {
    implementation(libs.dagger)
    implementation(libs.dagger.compiler)
}
