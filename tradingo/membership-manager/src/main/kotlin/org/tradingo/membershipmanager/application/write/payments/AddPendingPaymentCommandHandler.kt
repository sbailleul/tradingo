package org.tradingo.membershipmanager.application.write.payments

import io.jkratz.mediator.core.Command
import io.jkratz.mediator.core.CommandHandler
import org.springframework.stereotype.Component
import org.tradingo.membershipmanager.application.contracts.PaymentRepository
import org.tradingo.membershipmanager.domain.members.MemberId
import org.tradingo.membershipmanager.domain.members.PaymentAggregate
import java.time.LocalDateTime


data class AddPendingPaymentCommand(
    val startDate: LocalDateTime,
    val frequencyMs: Long?,
    val memberId: MemberId,
    val amount: Double
) : Command

@Component
class AddPendingPaymentCommandHandler(private val paymentRepository: PaymentRepository) :
    CommandHandler<AddPendingPaymentCommand> {

    override fun handle(command: AddPendingPaymentCommand) {
        val paymentId = paymentRepository.nextId()
        val paymentAggregate = PaymentAggregate.createNew(
            id = paymentId,
            startDate = command.startDate,
            memberId = command.memberId,
            amount = command.amount,
            frequencyMs = command.frequencyMs
        )
        paymentRepository.save(paymentAggregate)
    }

}