package org.tradingo.membershipmanager.infrastructure.repositories

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.tradingo.membershipmanager.application.contracts.PaymentRepository
import org.tradingo.membershipmanager.domain.members.MemberId
import org.tradingo.membershipmanager.domain.members.PaymentAggregate
import org.tradingo.membershipmanager.domain.members.PaymentId
import org.tradingo.membershipmanager.infrastructure.jparepositories.JpaPaymentRepository
import org.tradingo.membershipmanager.infrastructure.models.PaymentModel
import java.util.*

@Repository
class PaymentRepositoryImpl(private val repository: JpaPaymentRepository) : PaymentRepository {
    private fun toModel(aggregate: PaymentAggregate): PaymentModel {
        val model = PaymentModel()
        model.amount = aggregate.amount
        model.frequencyMs = aggregate.frequencyMs
        model.id = aggregate.id.value
        model.lastTransactionDate = aggregate.lastTransactionDate
        model.memberId = aggregate.memberId.value
        model.startDate = aggregate.startDate
        return model
    }

    private fun toAggregate(model: PaymentModel) = PaymentAggregate.restore(
        id = PaymentId(model.id), startDate = model.startDate, lastTransactionDate = model.lastTransactionDate,
        memberId = MemberId(model.memberId), amount = model.amount, frequencyMs = model.frequencyMs
    )

    override fun findById(id: PaymentId): PaymentAggregate? {
        return repository.findByIdOrNull(id.value)?.let {
            toAggregate(it)
        }
    }

    override fun findAll(): List<PaymentAggregate> {
        return repository.findAll().map { toAggregate(it) }
    }

    override fun save(aggregate: PaymentAggregate): PaymentId {
        val model = toModel(aggregate)
        repository.save(model)
        return PaymentId(model.id)
    }

    override fun nextId(): PaymentId = PaymentId(UUID.randomUUID())
    override fun remove(id: PaymentId) {
        repository.deleteById(id.value)
    }
}