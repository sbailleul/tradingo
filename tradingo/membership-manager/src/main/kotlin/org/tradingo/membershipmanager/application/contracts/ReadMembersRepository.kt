package org.tradingo.membershipmanager.application.contracts

import java.util.*

interface ReadMembersRepository {

    fun findMembersIdsByProjectId(projectId: UUID): List<UUID>
}