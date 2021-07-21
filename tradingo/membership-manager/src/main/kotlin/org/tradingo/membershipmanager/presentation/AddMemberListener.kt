package org.tradingo.membershipmanager.presentation

import io.jkratz.mediator.core.Mediator
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.presentation.kafka.TradingoKafkaListener

@Service
class AddMemberListener(val mediator: Mediator) : TradingoKafkaListener<AddMemberMessage> {

    @KafkaListener(topics = [Topics.ADD_MEMBER])
    override fun listen(message: AddMemberMessage) {
        mediator.dispatch(message.to())
    }
}

