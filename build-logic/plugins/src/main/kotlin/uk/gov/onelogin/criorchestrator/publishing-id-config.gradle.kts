package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.customisePublications
import uk.gov.onelogin.criorchestrator.extensions.modulePathAsArtifactId
import uk.gov.onelogin.criorchestrator.extensions.modulePathAsGroupId

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

configure<PublishingExtension> {
    customisePublications(
        groupId = project.modulePathAsGroupId(),
        artifactId = project.modulePathAsArtifactId(),
    )
}
