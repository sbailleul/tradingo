package org.tradingo.membershipmanager.infrastructure.models

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "payment", schema = "payments")
class PaymentModel {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    lateinit var id: UUID

    @Column(name = "start_date")
    lateinit var startDate: LocalDateTime

    @Column(name = "last_transaction_date")
    var lastTransactionDate: LocalDateTime? = null

    @Column(name = "frequency_ms")
    var frequencyMs: Long? = null

    @Column(name = "member_id")
    lateinit var memberId: UUID

    @Column(name = "amount")
    var amount: Double = 0.0

}



