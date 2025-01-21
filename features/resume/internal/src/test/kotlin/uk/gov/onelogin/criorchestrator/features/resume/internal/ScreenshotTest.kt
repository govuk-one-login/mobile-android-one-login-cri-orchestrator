package uk.gov.onelogin.criorchestrator.features.resume.internal

import android.content.res.Configuration
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.resources.NightMode
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.google.testing.junit.testparameterinjector.TestParameterValuesProvider
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sergio.sastre.composable.preview.scanner.android.AndroidComposablePreviewScanner
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.android.screenshotid.AndroidPreviewScreenshotIdBuilder
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview

@RunWith(TestParameterInjector::class)
class ScreenshotTest(
    @TestParameter(valuesProvider = ComposablePreviewProvider::class)
    preview: ComposablePreview<AndroidPreviewInfo>,
): BaseScreenshotTest(preview = preview)

abstract class BaseScreenshotTest(
    val preview: ComposablePreview<AndroidPreviewInfo>,
) {

    @get:Rule
    val paparazzi: Paparazzi = PaparazziPreviewRule.createFor(preview)

    @Test
    fun screenshot() {
        val name = createScreenshotIdFor(preview)
        paparazzi.snapshot(name = name) {
            preview()
        }
    }
}

object ComposablePreviewProvider : TestParameterValuesProvider() {
    override fun provideValues(context: Context?): List<ComposablePreview<AndroidPreviewInfo>> =
        AndroidComposablePreviewScanner()
            .scanPackageTrees("uk.gov.onelogin.criorchestrator")
            .getPreviews()
}

object PaparazziPreviewRule {
    fun createFor(preview: ComposablePreview<AndroidPreviewInfo>): Paparazzi =
        Paparazzi(
            deviceConfig = DeviceConfig(
                nightMode = when (preview.previewInfo.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) {
                    true -> NightMode.NIGHT
                    false -> NightMode.NOTNIGHT
                }
            ),
        )
}

fun createScreenshotIdFor(preview: ComposablePreview<AndroidPreviewInfo>) =
    AndroidPreviewScreenshotIdBuilder(preview)
        // Paparazzi screenshot names already include className and methodName
        .ignoreClassName()
        .ignoreMethodName()
        .build()