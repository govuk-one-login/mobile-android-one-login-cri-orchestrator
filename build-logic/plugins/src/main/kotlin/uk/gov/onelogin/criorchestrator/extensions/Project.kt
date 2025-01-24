package uk.gov.onelogin.criorchestrator.extensions

import org.gradle.api.Project

/**
 * Gets the module path in the style of a Java package.
 *
 * For example, given a module with the module path `:features:user:api` it returns
 * `features.user.api`.
 *
 * @return The project's module path in the style of a Java package
 */
internal fun Project.modulePathAsPackage(): String =
    project.path
        .lowercase()
        .removePrefix(":")
        .replace("-", "")
        .replace(":", ".")

