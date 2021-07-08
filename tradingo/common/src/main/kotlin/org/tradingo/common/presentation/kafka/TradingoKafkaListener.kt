package org.tradingo.common.presentation.kafka

interface TradingoKafkaListener<TIn> {
    fun listen(message: TIn)
}