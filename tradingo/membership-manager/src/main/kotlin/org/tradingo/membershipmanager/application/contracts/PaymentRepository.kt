package org.tradingo.membershipmanager.application.contracts

import org.tradingo.common.application.contracts.AggregateRepository
import org.tradingo.membershipmanager.domain.members.PaymentAggregate
import org.tradingo.membershipmanager.domain.members.PaymentId

interface PaymentRepository : AggregateRepository<PaymentId, PaymentAggregate> {
}