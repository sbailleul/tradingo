package org.tradingo.common.application.contracts

interface KafkaProducer<TMessage> {
    fun sendMessage(message: TMessage)
}