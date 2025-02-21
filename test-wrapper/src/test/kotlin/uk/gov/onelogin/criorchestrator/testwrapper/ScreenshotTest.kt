package uk.gov.onelogin.criorchestrator.testwrapper

import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.runner.RunWith
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview
import uk.gov.onelogin.criorchestrator.libraries.screenshottesting.BaseScreenshotTest
import uk.gov.onelogin.criorchestrator.libraries.screenshottesting.PackagePreviewsProvider

private object ModulePackagePreviewsProvider : PackagePreviewsProvider()

// There is a known issue with the screenshot tests rendering the `FullScreenDialog` weirdly, making
// it look thin. For some reason, the way the view model and view model scoped coroutine work, this
// causes inconsistencies with the aforementioned rendering issue - the first screenshot test always
// has this rendering issue, and the second screenshot test never has the rendering issue, and so
// the results remain deterministic.
@RunWith(TestParameterInjector::class)
class ScreenshotTest(
    @TestParameter(
        valuesProvider = ModulePackagePreviewsProvider::class,
    )
    preview: ComposablePreview<AndroidPreviewInfo>,
) : BaseScreenshotTest(preview = preview)
