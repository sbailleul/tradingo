package org.tradingo.marketmanager.domain.projects

import org.tradingo.common.domain.Aggregate
import org.tradingo.common.domain.projects.ProjectId
import java.time.LocalDateTime

class ProjectAggregate : Aggregate<ProjectId> {
    private var _id: ProjectId
    override val id: ProjectId get() = _id

    private var _startDate: LocalDateTime
    val startDate: LocalDateTime get() = _startDate

    private var _endDate: LocalDateTime?
    val endDate: LocalDateTime? get() = _endDate

    private var _name: String
    val name: String get() = _name

    private var _description: String
    val description: String get() = _description


    private constructor(
        id: ProjectId,
        startDate: LocalDateTime,
        endDate: LocalDateTime?,
        name: String,
        description: String
    ) {
        _id = id
        _startDate = startDate
        _endDate = endDate
        _name = name
        _description = description
    }

    companion object {
        fun createNew(
            id: ProjectId,
            startDate: LocalDateTime,
            name: String,
            description: String
        ) = ProjectAggregate(id, startDate, null, name, description)

        fun restore(
            id: ProjectId,
            startDate: LocalDateTime,
            endDate: LocalDateTime?,
            name: String,
            description: String
        ) = ProjectAggregate(id, startDate, endDate, name, description)
    }

    fun close(endDate: LocalDateTime){
        _endDate = endDate
    }
}