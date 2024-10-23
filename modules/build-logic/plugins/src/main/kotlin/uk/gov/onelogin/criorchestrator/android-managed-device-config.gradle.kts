package uk.gov.onelogin.criorchestrator

import com.android.build.gradle.BaseExtension
import uk.gov.onelogin.criorchestrator.extensions.libs

listOf(
    libs.plugins.android.base,
).forEach {
    project.plugins.apply(it.get().pluginId)
}

configure<BaseExtension> {
    testOptions {
        managedDevices {
            devices {
                localDevices {
                    create("defaultAtd") {
                        device = "Pixel XL"
                        apiLevel = 34
                        systemImageSource = "aosp-atd"
                    }
                }
            }
        }
    }
}
