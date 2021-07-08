package org.tradingo.membershipmanager.infrastructure.repositories

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.tradingo.common.domain.members.MemberType
import org.tradingo.membershipmanager.application.contracts.MemberRepository
import org.tradingo.membershipmanager.domain.members.MemberAggregate
import org.tradingo.membershipmanager.domain.members.MemberId
import org.tradingo.membershipmanager.infrastructure.jparepositories.JpaMemberRepository
import org.tradingo.membershipmanager.infrastructure.models.MemberModel
import java.util.*

@Repository
class TradesmanRepositoryImpl(val repository: JpaMemberRepository) : MemberRepository {

    private fun toAggregate(member: MemberModel) =
        MemberAggregate.restore(
            id = MemberId(member.id),
            type = member.type,
            username = member.username,
            email = member.email,
            password = member.password,
            firstname = member.firstname,
            lastname = member.lastname
        )

    private fun toModel(aggregate: MemberAggregate): MemberModel {
        val member = MemberModel()
        member.type = aggregate.type
        member.email = aggregate.email
        member.firstname = aggregate.firstname
        member.lastname = aggregate.lastname
        member.password = aggregate.password
        member.id = aggregate.id.value
        return member
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