package org.tradingo.membershipmanager.infrastructure.jparepositories

import org.springframework.data.jpa.repository.JpaRepository
import org.tradingo.membershipmanager.infrastructure.models.PaymentModel
import java.util.*

interface JpaPaymentRepository : JpaRepository<PaymentModel, UUID> {
}