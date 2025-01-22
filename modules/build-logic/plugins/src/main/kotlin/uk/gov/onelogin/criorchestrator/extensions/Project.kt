package uk.gov.onelogin.criorchestrator.extensions

import org.gradle.api.Project

/**
 * Gets the module path in the style of a Java package.
 *
 * If the module path starts with `:modules`, this segment is not included in the result.
 *
 * For example, given a module with the module path `:modules:features:user:api` it returns
 * `features.user.api`.
 *
 * @return The project's module path in the style of a Java package
 */
internal fun Project.modulePathAsPackage(): String =
    project.path
        .lowercase()
        .removePrefix(":")
        .removePrefix("modules:")
        .replace("-", "")
        .replace(":", ".")

