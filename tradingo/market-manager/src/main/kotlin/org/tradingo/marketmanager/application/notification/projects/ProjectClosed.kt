package org.tradingo.marketmanager.application.notification.projects

import io.jkratz.mediator.core.Command
import java.util.*

data class ProjectClosed(val projectId: UUID): Command {
}