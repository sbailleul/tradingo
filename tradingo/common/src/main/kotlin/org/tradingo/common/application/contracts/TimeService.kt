package org.tradingo.common.application.contracts

import java.time.LocalDateTime

interface TimeService {
    fun now(): LocalDateTime
}