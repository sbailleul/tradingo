package org.tradingo.genericclient.presentation.web

import io.jkratz.mediator.core.Mediator
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.tradingo.genericclient.application.CloseProjectCommand
import java.util.*


@RestController
@RequestMapping("projects")
class ProjectsController(val mediator: Mediator) {

    @DeleteMapping(":id")
    fun closeProject(id: UUID) {
        mediator.dispatch(
            CloseProjectCommand(id)
        )
    }
}