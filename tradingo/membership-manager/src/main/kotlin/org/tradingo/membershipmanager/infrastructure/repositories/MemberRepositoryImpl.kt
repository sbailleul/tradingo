package org.tradingo.membershipmanager.infrastructure.repositories

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.tradingo.common.domain.projects.ProjectId
import org.tradingo.membershipmanager.application.contracts.MemberRepository
import org.tradingo.membershipmanager.domain.members.MemberAggregate
import org.tradingo.membershipmanager.domain.members.MemberId
import org.tradingo.membershipmanager.domain.members.ProjectEntity
import org.tradingo.membershipmanager.infrastructure.jparepositories.JpaMemberRepository
import org.tradingo.membershipmanager.infrastructure.models.MemberModel
import org.tradingo.membershipmanager.infrastructure.models.ProjectMemberModel
import java.util.*

@Repository
class MemberRepositoryImpl(val repository: JpaMemberRepository) : MemberRepository {

    private fun toAggregate(member: MemberModel) =
        MemberAggregate.restore(
            id = MemberId(member.id),
            type = member.type,
            username = member.username,
            email = member.email,
            password = member.password,
            firstname = member.firstname,
            lastname = member.lastname,
            projects = member.projects.map { toProjectEntity(it) }
        )

    private fun toProjectEntity(project: ProjectMemberModel) =
        ProjectEntity(ProjectId(project.id), project.joinDate, project.leaveDate)

    private fun toProjectModel(project: ProjectEntity): ProjectMemberModel {
        val model = ProjectMemberModel()
        model.leaveDate = project.leaveDate
        model.joinDate = project.joinDate
        return model
    }

    private fun updateExistingProjects(memberModel: MemberModel, aggregate: MemberAggregate) =
        memberModel.projects.forEach {
            aggregate.projects.forEach { project ->
                if (project.id.value == it.projectId) {
                    it.joinDate = project.joinDate
                    it.leaveDate = project.leaveDate
                }
            }
        }

    private fun insertAddedProjects(memberModel: MemberModel, aggregate: MemberAggregate) =
        aggregate.projects.filter {
            memberModel.projects.none { project ->
                project.projectId == it.id.value
            }
        }.forEach {
            memberModel.projects.add(
                toProjectModel(it)
            )
        }

    private fun deleteRemovedProjects(memberModel: MemberModel, aggregate: MemberAggregate) {
        memberModel.projects.filter {
            aggregate.projects.none { project ->
                project.id.value == it.projectId
            }
        }.forEach { memberModel.projects.remove(it) }
    }


    private fun toModel(aggregate: MemberAggregate): MemberModel {
        val model = repository.findByIdOrNull(aggregate.id.value) ?: MemberModel()
        model.type = aggregate.type
        model.email = aggregate.email
        model.firstname = aggregate.firstname
        model.lastname = aggregate.lastname
        model.password = aggregate.password
        model.id = aggregate.id.value
        updateExistingProjects(model, aggregate)
        deleteRemovedProjects(model, aggregate)
        insertAddedProjects(model, aggregate)
        return model
    }

    override fun findById(id: MemberId): MemberAggregate? {
        val member = repository.findByIdOrNull(id.value)
        return member?.let {
            toAggregate(member)
        }
    }

    override fun findAll(): List<MemberAggregate> {
        return repository.findAll().map { toAggregate(it) }
    }

    override fun save(aggregate: MemberAggregate): MemberId {
        val model = toModel(aggregate)
        repository.save(model)
        return MemberId(model.id)
    }

    override fun nextId(): MemberId = MemberId(UUID.randomUUID())

    override fun remove(id: MemberId) {
        repository.deleteById(id.value)
    }
}