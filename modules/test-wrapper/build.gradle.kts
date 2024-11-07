import com.android.build.api.dsl.ApplicationExtension
import uk.gov.onelogin.criorchestrator.extensions.setApplicationId
import uk.gov.onelogin.criorchestrator.extensions.setNamespace

plugins {
    id("uk.gov.onelogin.criorchestrator.android-app-config")
}

configure<ApplicationExtension> {
    setApplicationId(suffix = ".testwrapper")
    setNamespace(suffix = ".testwrapper")

    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }
}
