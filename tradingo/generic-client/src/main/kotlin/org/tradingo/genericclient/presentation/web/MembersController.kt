package org.tradingo.genericclient.presentation.web

import io.jkratz.mediator.core.Mediator
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.tradingo.common.domain.members.MemberType
import org.tradingo.genericclient.application.AddMemberCommand
import org.tradingo.genericclient.application.PaymentInformation

@RestController
@RequestMapping("members")
class MembersController(val mediator: Mediator) {

    data class AddMemberRequest(
        var username: String,
        var email: String,
        var firstname: String,
        var lastname: String,
        var password: String,
        var type: MemberType,
        var paymentInfo: PaymentInformation
    ) {
        data class PaymentInformation(var amount: Double, var frequencyMs: Long?)
    }

    @PostMapping
    fun addMember(@RequestBody req: AddMemberRequest) {
        mediator.dispatch(
            AddMemberCommand(
                username = req.username,
                email = req.email,
                firstname = req.firstname,
                lastname = req.lastname,
                password = req.password,
                type = req.type,
                paymentInfo = PaymentInformation(req.paymentInfo.frequencyMs, req.paymentInfo.amount)
            )
        )
    }
}