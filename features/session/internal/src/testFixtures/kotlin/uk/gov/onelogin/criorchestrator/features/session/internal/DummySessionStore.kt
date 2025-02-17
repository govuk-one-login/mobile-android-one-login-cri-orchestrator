package uk.gov.onelogin.criorchestrator.features.session.internal

import uk.gov.logging.api.Logger
import uk.gov.logging.testdouble.SystemLogger

fun dummySessionStore(logger: Logger = SystemLogger()): SessionStore = InMemorySessionStore(logger)
