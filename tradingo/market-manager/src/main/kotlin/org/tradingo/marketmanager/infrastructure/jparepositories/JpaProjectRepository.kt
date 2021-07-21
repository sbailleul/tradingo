package org.tradingo.marketmanager.infrastructure.jparepositories

import org.springframework.data.jpa.repository.JpaRepository
import org.tradingo.marketmanager.infrastructure.models.ProjectModel
import java.util.*

interface JpaProjectRepository : JpaRepository<ProjectModel, UUID> {
}