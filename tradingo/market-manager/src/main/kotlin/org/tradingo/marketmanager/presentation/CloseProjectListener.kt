package org.tradingo.marketmanager.presentation

import io.jkratz.mediator.core.Mediator
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.CloseProjectMessage
import org.tradingo.common.presentation.kafka.TradingoKafkaListener

@Service
class CloseProjectListener(val mediator: Mediator) : TradingoKafkaListener<CloseProjectMessage> {

    @KafkaListener(topics = [Topics.CLOSE_PROJECT])
    override fun listen(message: CloseProjectMessage) {
        mediator.dispatch(message.to())
    }
}