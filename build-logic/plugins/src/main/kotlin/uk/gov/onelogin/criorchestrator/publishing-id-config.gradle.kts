package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import uk.gov.onelogin.criorchestrator.extensions.BASE_NAMESPACE
import uk.gov.onelogin.criorchestrator.extensions.setPublishingArtifactId

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

configure<PublishingExtension> {
    val projectPath = project.projectDir.relativeTo(project.rootDir).toString().split("/")
    publications {
        this.withType<MavenPublication>().forEach {
            it.groupId = "$BASE_NAMESPACE.${projectPath[0]}"
        }
    }
    setPublishingArtifactId("${projectPath[projectPath.size - 2]}-${projectPath.last()}")
}
