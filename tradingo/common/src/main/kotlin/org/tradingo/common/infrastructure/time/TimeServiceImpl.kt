package org.tradingo.common.infrastructure.time

import org.springframework.stereotype.Service
import org.tradingo.common.application.contracts.TimeService
import java.time.LocalDateTime
import java.time.ZoneOffset

@Service
class TimeServiceImpl: TimeService {
    override fun now(): LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
}