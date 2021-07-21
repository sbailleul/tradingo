package org.tradingo.membershipmanager.presentation

import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.presentation.input.LeaveProjectMessage
import org.tradingo.membershipmanager.application.AddMemberCommand
import org.tradingo.membershipmanager.application.LeaveProjectCommand
import org.tradingo.membershipmanager.application.PaymentInformation

fun AddMemberMessage.to(): AddMemberCommand = AddMemberCommand(
    username,
    email,
    firstname,
    lastname,
    password,
    type,
    PaymentInformation(paymentInfo.frequencyMs, paymentInfo.amount)
)

fun LeaveProjectMessage.to(): LeaveProjectCommand = LeaveProjectCommand(projectId)