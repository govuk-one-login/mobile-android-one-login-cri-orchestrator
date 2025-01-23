package uk.gov.onelogin.criorchestrator.libraries.screenshottesting

import com.google.testing.junit.testparameterinjector.TestParameterValuesProvider
import sergio.sastre.composable.preview.scanner.android.AndroidComposablePreviewScanner
import sergio.sastre.composable.preview.scanner.android.AndroidPreviewInfo
import sergio.sastre.composable.preview.scanner.core.preview.ComposablePreview

private const val BASE_PACKAGE = "uk.gov.onelogin.criorchestrator"

/**
 * A [TestParameterValuesProvider] that provides all the composable previews found in the project.
 */
class AllPreviewsProvider : TestParameterValuesProvider() {
    override fun provideValues(context: Context?): List<ComposablePreview<AndroidPreviewInfo>> =
        AndroidComposablePreviewScanner()
            .scanPackageTrees(BASE_PACKAGE)
            .getPreviews()
}
