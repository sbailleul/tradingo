package org.tradingo.membershipmanager.infrastructure.repositories

import org.springframework.stereotype.Repository
import org.tradingo.common.utils.plusMilliseconds
import org.tradingo.membershipmanager.application.contracts.ReadPaymentsRepository
import org.tradingo.membershipmanager.infrastructure.jparepositories.JpaPaymentRepository
import java.time.LocalDateTime
import java.util.*

@Repository
class ReadPaymentsRepositoryImpl(private val repository: JpaPaymentRepository) : ReadPaymentsRepository {

    override fun getAllUnacknowledgedPaymentsIdsByDate(date: LocalDateTime): List<UUID> {
        return repository.findAll()
            .filter {
            val transactionDate = it.lastTransactionDate ?: it.startDate
            it.frequencyMs != null && transactionDate.plusMilliseconds(it.frequencyMs) > date
            }
            .map { it.id }
    }
}