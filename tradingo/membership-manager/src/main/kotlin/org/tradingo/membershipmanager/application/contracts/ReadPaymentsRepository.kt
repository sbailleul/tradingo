package org.tradingo.membershipmanager.application.contracts

import java.time.LocalDateTime
import java.util.*

interface ReadPaymentsRepository {

    fun getAllUnacknowledgedPaymentsIdsByDate(date: LocalDateTime): List<UUID>
}