package org.tradingo.genericclient.infrastructure.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.KafkaProducerImpl
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.genericclient.application.contracts.AddMemberProducer

@Service
class AddMemberProducerImpl(template: KafkaTemplate<String, Any>) : KafkaProducerImpl<AddMemberMessage>(template),
    AddMemberProducer {
    override fun sendMessage(message: AddMemberMessage) {
        send(Topics.ADD_MEMBER, message)
    }
}