package com.esgi.tradingo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*


data class KafkaMessage(val content: String, val topic: String)

@RestController
@RequestMapping("kafka")
class KafkaController constructor(val producer: KafkaProducer) {
    val logger: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)

    @PostMapping("/produce")
    fun sendMessage(@RequestBody message: KafkaMessage): ResponseEntity<String> {
        val result = producer.send(message)
        return ResponseEntity.ok("$result sent to topic")
    }
}

@Service
class KafkaProducer constructor(val template: KafkaTemplate<String, String>) {
    val logger: Logger = LoggerFactory.getLogger(KafkaProducer::class.java)

    fun send(message: KafkaMessage): String {
        try {
            val lf = template.send(message.topic, message.content)
            val sendResult = lf.get()
            return sendResult.producerRecord.value()
        } catch (e: Error) {
            logger.error(e.message);
            throw e
        }
    }
}