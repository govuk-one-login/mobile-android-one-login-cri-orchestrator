package uk.gov.onelogin.criorchestrator

import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.testDependencies

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

configure<BaseExtension> {
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
            it.testLogging {
                events = setOf(
                    TestLogEvent.SKIPPED,
                    TestLogEvent.FAILED,
                )
            }
        }
    }
}

dependencies {
    testDependencies(libs)
}

