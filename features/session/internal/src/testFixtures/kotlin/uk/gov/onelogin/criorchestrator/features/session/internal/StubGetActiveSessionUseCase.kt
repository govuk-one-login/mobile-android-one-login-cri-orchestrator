package uk.gov.onelogin.criorchestrator.features.session.internal

import uk.gov.onelogin.criorchestrator.features.session.internalapi.GetActiveSessionUseCase

class StubGetActiveSessionUseCase(
    private val sessionActiveStatus: Boolean = true,
) : GetActiveSessionUseCase {
    override suspend fun execute(): Boolean = sessionActiveStatus
}
