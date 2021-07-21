package org.tradingo.genericclient.application

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.springframework.stereotype.Component
import org.tradingo.common.presentation.input.CloseProjectMessage
import org.tradingo.genericclient.application.contracts.CloseProjectProducer
import java.util.*

data class CloseProjectCommand(val projectId: UUID) : Request<Unit>

@Component
class CloseProjectCommandHandler(val producer: CloseProjectProducer) : RequestHandler<CloseProjectCommand, Unit> {

    override fun handle(request: CloseProjectCommand) {
        val message = CloseProjectMessage()
        message.projectId = request.projectId
        producer.sendMessage(message)
    }
}