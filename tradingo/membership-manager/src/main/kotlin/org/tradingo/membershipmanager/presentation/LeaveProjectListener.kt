package org.tradingo.membershipmanager.presentation

import io.jkratz.mediator.core.Mediator
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.presentation.input.LeaveProjectMessage
import org.tradingo.common.presentation.kafka.TradingoKafkaListener

@Service
class LeaveProjectListener(val mediator: Mediator) : TradingoKafkaListener<LeaveProjectMessage> {

    @KafkaListener(topics = [Topics.LEAVE_PROJECT])
    override fun listen(message: LeaveProjectMessage) {
        mediator.dispatch(message.to())
    }
}