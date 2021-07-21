package org.tradingo.membershipmanager.domain.members

import org.tradingo.common.domain.Aggregate
import java.time.LocalDateTime
import java.util.*

data class PaymentId(val value: UUID)
class PaymentAggregate : Aggregate<PaymentId> {
    private var _id: PaymentId
    private var _startDate: LocalDateTime
    private var _lastTransactionDate: LocalDateTime?
    private var _frequencyMs: Long?
    private var _memberId: MemberId
    private var _amount: Double

    override val id get() = _id
    val startDate get() = _startDate
    val lastTransactionDate get() = _lastTransactionDate
    val frequencyMs get() = _frequencyMs
    val memberId get() = _memberId
    val amount get() = _amount

    private constructor(
        id: PaymentId,
        startDate: LocalDateTime,
        lastTransactionDate: LocalDateTime?,
        memberId: MemberId,
        amount: Double,
        frequencyMs: Long?,
    ) {
        _id = id
        _startDate = startDate
        _lastTransactionDate = lastTransactionDate
        _memberId = memberId
        _frequencyMs = frequencyMs
        _amount = amount
    }

    companion object {
        fun createNew(
            id: PaymentId,
            startDate: LocalDateTime,
            memberId: MemberId,
            amount: Double,
            frequencyMs: Long?
        ) = PaymentAggregate(id, startDate, null, memberId, amount, frequencyMs)

        fun restore(
            id: PaymentId,
            startDate: LocalDateTime,
            lastTransactionDate: LocalDateTime?,
            memberId: MemberId,
            amount: Double,
            frequencyMs: Long?
        ) = PaymentAggregate(id, startDate, lastTransactionDate, memberId, amount, frequencyMs)
    }

    fun acknowledge(date: LocalDateTime){
        _lastTransactionDate = date
    }

}