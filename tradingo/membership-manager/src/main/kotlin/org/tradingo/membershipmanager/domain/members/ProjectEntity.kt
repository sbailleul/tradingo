package org.tradingo.membershipmanager.domain.members

import org.tradingo.common.domain.Entity
import org.tradingo.common.domain.projects.ProjectId
import java.time.LocalDateTime

class ProjectEntity(override val id: ProjectId, var joinDate: LocalDateTime, var leaveDate: LocalDateTime?) :
    Entity<ProjectId>() {
}