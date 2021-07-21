package org.tradingo.marketmanager.infrastructure.kafka

import io.jkratz.mediator.core.CommandHandler
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.tradingo.common.infrastructure.kafka.KafkaProducerImpl
import org.tradingo.common.infrastructure.kafka.Topics
import org.tradingo.common.presentation.input.LeaveProjectMessage
import org.tradingo.marketmanager.application.notification.projects.ProjectClosed

@Service
class LeaveProjectKafkaProducer(template: KafkaTemplate<String, Any>) :
    KafkaProducerImpl<LeaveProjectMessage>(template), CommandHandler<ProjectClosed> {

    override fun sendMessage(message: LeaveProjectMessage) {
        send(Topics.LEAVE_PROJECT, message)
    }

    override fun handle(command: ProjectClosed) {
        val message = LeaveProjectMessage()
        message.projectId = command.projectId
        sendMessage(message)
    }
}