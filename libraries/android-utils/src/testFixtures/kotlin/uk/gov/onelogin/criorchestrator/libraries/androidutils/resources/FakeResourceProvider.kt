package uk.gov.onelogin.criorchestrator.libraries.androidutils.resources

class FakeResourceProvider : ResourceProvider {
    override fun getEnglishString(resId: Int): String = "dummy string"
}
