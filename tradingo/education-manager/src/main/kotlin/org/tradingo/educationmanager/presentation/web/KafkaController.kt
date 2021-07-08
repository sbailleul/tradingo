package org.tradingo.educationmanager.presentation.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.tradingo.common.presentation.input.AddMemberMessage
import org.tradingo.common.infrastructure.kafka.KafkaProducerImpl


data class KafkaMessage<T>(val content: T, val topic: String)

@RestController
@RequestMapping("kafka")
class KafkaController constructor(val producer: KafkaProducerImpl) {
    val logger: Logger = LoggerFactory.getLogger(KafkaController::class.java)

    @PostMapping("/produce")
    fun sendMessage(@RequestBody message: KafkaMessage<AddMemberMessage>): ResponseEntity<String> {
        logger.info(message.toString())
        val result = producer.send(message.topic, message.content)
        return ResponseEntity.ok("$result sent to topic")
    }
}

