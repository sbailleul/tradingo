package org.tradingo.marketmanager.infrastructure.repositories

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.tradingo.marketmanager.application.contracts.ProjectRepository
import org.tradingo.marketmanager.domain.projects.ProjectAggregate
import org.tradingo.common.domain.projects.ProjectId
import org.tradingo.marketmanager.infrastructure.jparepositories.JpaProjectRepository
import org.tradingo.marketmanager.infrastructure.models.ProjectModel
import java.util.*

@Repository
class ProjectRepositoryImpl(private val jpaProjectRepository: JpaProjectRepository) : ProjectRepository {

    private fun toModel(aggregate: ProjectAggregate): ProjectModel {
        val model = ProjectModel()
        model.description = aggregate.description
        model.endDate = aggregate.endDate
        model.name = aggregate.name
        model.startDate = aggregate.startDate
        return model
    }

    private fun toAggregate(model: ProjectModel) = ProjectAggregate.restore(
        id = ProjectId(model.id),
        startDate = model.startDate,
        endDate = model.endDate,
        name = model.name,
        description = model.description
    )

    override fun findById(id: ProjectId): ProjectAggregate? {
        return jpaProjectRepository.findByIdOrNull(id.value)?.let {
            toAggregate(it)
        }
    }

    override fun findAll(): List<ProjectAggregate> {
        return jpaProjectRepository.findAll().map { toAggregate(it) }
    }

    override fun save(aggregate: ProjectAggregate): ProjectId {
        val model = toModel(aggregate)
        jpaProjectRepository.save(model)
        return ProjectId(model.id)
    }

    override fun nextId(): ProjectId = ProjectId(UUID.randomUUID())

    override fun remove(id: ProjectId) {
        jpaProjectRepository.deleteById(id.value)
    }
}