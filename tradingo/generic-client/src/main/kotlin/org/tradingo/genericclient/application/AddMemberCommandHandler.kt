package org.tradingo.genericclient.application

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.springframework.stereotype.Component
import org.tradingo.common.domain.members.MemberType
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.presentation.input.PaymentInfo
import org.tradingo.genericclient.application.contracts.AddMemberProducer


data class PaymentInformation(val frequencyMs: Long?, val amount: Double)
data class AddMemberCommand(
    val username: String,
    val email: String,
    val firstname: String,
    val lastname: String,
    val password: String,
    val type: MemberType,
    val paymentInfo: PaymentInformation
) : Request<Unit>

@Component
class AddMemberCommandHandler(
    val producer: AddMemberProducer
) : RequestHandler<AddMemberCommand, Unit> {

    override fun handle(request: AddMemberCommand) {
        val message = AddMemberMessage()
        val paymentInfo = PaymentInfo()
        paymentInfo.amount = request.paymentInfo.amount
        paymentInfo.frequencyMs = request.paymentInfo.frequencyMs
        message.email = request.email
        message.firstname = request.firstname
        message.lastname = request.lastname
        message.username = request.username
        message.password = request.password
        message.type = request.type
        message.paymentInfo = paymentInfo
        producer.sendMessage(message)
    }

}