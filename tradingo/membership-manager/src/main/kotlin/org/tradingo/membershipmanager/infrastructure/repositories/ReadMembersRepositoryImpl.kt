package org.tradingo.membershipmanager.infrastructure.repositories

import org.springframework.stereotype.Repository
import org.tradingo.membershipmanager.application.contracts.ReadMembersRepository
import org.tradingo.membershipmanager.infrastructure.jparepositories.JpaMemberRepository
import java.util.*

@Repository
class ReadMembersRepositoryImpl(private val readMembersRepository: JpaMemberRepository) : ReadMembersRepository {
    override fun findMembersIdsByProjectId(projectId: UUID): List<UUID> {
        return readMembersRepository.findAll().filter {
            it.projects.any { project -> project.projectId == projectId }
        }.map { it.id }
    }

}