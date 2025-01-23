package uk.gov.onelogin.criorchestrator.features.resume.internal

import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.runner.RunWith
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview
import uk.gov.onelogin.criorchestrator.libraries.screenshottesting.AllPreviewsProvider
import uk.gov.onelogin.criorchestrator.libraries.screenshottesting.BaseScreenshotTest

@RunWith(TestParameterInjector::class)
class ScreenshotTest(
    @TestParameter(
        valuesProvider = AllPreviewsProvider::class,
    )
    preview: ComposablePreview<AndroidPreviewInfo>,
) : BaseScreenshotTest(preview = preview)
