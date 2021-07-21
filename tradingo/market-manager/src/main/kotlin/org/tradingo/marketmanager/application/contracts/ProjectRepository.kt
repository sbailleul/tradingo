package org.tradingo.marketmanager.application.contracts

import org.tradingo.common.application.contracts.AggregateRepository
import org.tradingo.marketmanager.domain.projects.ProjectAggregate
import org.tradingo.common.domain.projects.ProjectId

interface ProjectRepository : AggregateRepository<ProjectId, ProjectAggregate> {

}