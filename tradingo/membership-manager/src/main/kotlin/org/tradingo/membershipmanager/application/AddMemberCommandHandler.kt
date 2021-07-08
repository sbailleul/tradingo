package org.tradingo.membershipmanager.application

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.springframework.stereotype.Component
import org.tradingo.common.application.contracts.HashService
import org.tradingo.common.domain.members.MemberType
import org.tradingo.membershipmanager.application.contracts.MemberRepository
import org.tradingo.membershipmanager.domain.members.MemberAggregate

data class AddMemberCommand(
    val username: String,
    val email: String,
    val firstname: String,
    val lastname: String,
    val password: String,
    val type: MemberType
) : Request<Unit>

@Component
class AddMemberCommandHandler(
    val memberRepository: MemberRepository,
    val hashService: HashService
) : RequestHandler<AddMemberCommand, Unit> {

    override fun handle(request: AddMemberCommand) {
        val id = memberRepository.nextId()
        val member = MemberAggregate.createNew(
            id = id,
            type = request.type,
            username = request.username,
            email = request.email,
            password = hashService.hashPassword(request.password),
            firstname = request.firstname,
            lastname = request.lastname
        )
        memberRepository.save(member)
    }

}