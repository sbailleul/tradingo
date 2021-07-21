package org.tradingo.membershipmanager.application

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.springframework.stereotype.Component
import org.tradingo.common.domain.DomainException
import org.tradingo.common.domain.projects.ProjectId
import org.tradingo.membershipmanager.application.contracts.MemberRepository
import org.tradingo.membershipmanager.application.contracts.ReadMembersRepository
import org.tradingo.membershipmanager.domain.members.MemberId
import java.util.*

data class LeaveProjectCommand(val projectId: UUID) : Request<Unit>

@Component
class LeaveProjectCommandHandler(
    private val memberRepository: MemberRepository,
    private val readMemberRepository: ReadMembersRepository
) : RequestHandler<LeaveProjectCommand, Unit> {
    override fun handle(request: LeaveProjectCommand) {
        val projectId = ProjectId(request.projectId)
        readMemberRepository.findMembersIdsByProjectId(request.projectId).map {
            memberRepository.findById(MemberId(it)) ?: throw DomainException("Member $it not found")
        }.forEach {
            it.leaveProject(projectId)
            memberRepository.save(it)
        }

    }


}