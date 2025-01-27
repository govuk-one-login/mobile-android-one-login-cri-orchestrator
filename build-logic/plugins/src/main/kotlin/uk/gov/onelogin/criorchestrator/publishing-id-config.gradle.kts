package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.customisePublications
import uk.gov.onelogin.criorchestrator.extensions.modulePathAsArtifactId
import uk.gov.onelogin.criorchestrator.extensions.modulePathAsGroupId

listOf(
    "uk.gov.publishing.config"
).forEach {
    project.plugins.apply(it)
}

configure<PublishingExtension> {
    customisePublications {
        groupId = project.modulePathAsGroupId()
        artifactId = project.modulePathAsArtifactId()
    }
}
