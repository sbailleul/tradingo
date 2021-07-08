package org.tradingo.common.infrastructure.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.tradingo.common.application.contracts.KafkaProducer
import org.tradingo.common.infrastructure.exceptions.InfrastructureException

abstract class KafkaProducerImpl<TMessage> constructor(val template: KafkaTemplate<String, Any>) :
    KafkaProducer<TMessage> {

    private val logger: Logger = LoggerFactory.getLogger(KafkaProducerImpl::class.java)


    protected fun send(topic: String, message: TMessage) {
        try {
            template.send(topic, message)
            logger.info("Message sent to kafka topic $topic")
        } catch (e: Error) {
            logger.error("Cannot send message : ${message.toString()}, error :  ${e.message}")
            throw InfrastructureException(e.message)
        }
    }
}