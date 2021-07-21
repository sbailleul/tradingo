package org.tradingo.marketmanager.application.write

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.springframework.stereotype.Component
import org.tradingo.common.application.contracts.TimeService
import org.tradingo.common.domain.DomainException
import org.tradingo.marketmanager.application.contracts.ProjectRepository
import org.tradingo.common.domain.projects.ProjectId
import java.util.*

data class CloseProjectCommand(val projectId: UUID) : Request<Unit>

@Component
class CloseProjectCommandHandler(val projectRepository: ProjectRepository, val timeService: TimeService): RequestHandler<CloseProjectCommand, Unit> {

    override fun handle(request: CloseProjectCommand) {
        val projectId = ProjectId(request.projectId)
        projectRepository.findById(projectId)?.let { project ->
            project.close(timeService.now())
            projectRepository.save(project)
            return
        }
        throw DomainException("Project ${request.projectId} not found")
    }
}