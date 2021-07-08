package org.tradingo.membershipmanager.presentation

import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.membershipmanager.application.AddMemberCommand

fun AddMemberMessage.to(): AddMemberCommand = AddMemberCommand(username, email, firstname, lastname, password, type)