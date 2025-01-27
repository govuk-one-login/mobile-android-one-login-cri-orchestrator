package uk.gov.onelogin.criorchestrator.extensions

import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.withType
import uk.gov.publishing.MavenPublishingConfigPlugin

/**
 * Customise all Maven publications that have already been registered using
 * [MavenPublishingConfigPlugin].
 *
 * @param configuration Applied configuration to each Maven publication found.
 */
fun PublishingExtension.customisePublications(configuration: MavenPublication.() -> Unit) {
    publications {
        this.withType<MavenPublication>().forEach(configuration)
    }
}
