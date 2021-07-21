package org.tradingo.genericclient.infrastructure.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.KafkaProducerImpl
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.presentation.input.CloseProjectMessage
import org.tradingo.genericclient.application.contracts.AddMemberProducer
import org.tradingo.genericclient.application.contracts.CloseProjectProducer

@Service
class CloseProjectProducerImpl(template: KafkaTemplate<String, Any>) : KafkaProducerImpl<CloseProjectMessage>(template),
    CloseProjectProducer {
    override fun sendMessage(message: CloseProjectMessage) {
        send(Topics.CLOSE_PROJECT, message)
    }
}