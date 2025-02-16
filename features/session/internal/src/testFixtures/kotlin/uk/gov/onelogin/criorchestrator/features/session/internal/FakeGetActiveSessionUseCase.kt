package uk.gov.onelogin.criorchestrator.features.session.internal

import uk.gov.onelogin.criorchestrator.features.session.internalapi.GetActiveSessionUseCase

class FakeGetActiveSessionUseCase(
    private val sessionActiveStatus: Boolean = true,
): GetActiveSessionUseCase {
    override suspend fun execute(): Boolean = sessionActiveStatus
}
