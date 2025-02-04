package uk.gov.onelogin.criorchestrator.libraries.androidutils

class FakeResourceProvider : ResourceProvider {
    override fun getEnglishString(resId: Int): String = "dummy string"
}
