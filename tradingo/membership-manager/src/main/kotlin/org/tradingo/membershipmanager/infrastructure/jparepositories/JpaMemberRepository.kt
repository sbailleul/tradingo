package org.tradingo.membershipmanager.infrastructure.jparepositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.tradingo.common.domain.members.MemberType
import org.tradingo.membershipmanager.application.contracts.ReadMembersRepository
import org.tradingo.membershipmanager.infrastructure.models.MemberModel
import java.util.*

@Repository
interface JpaMemberRepository : JpaRepository<MemberModel, UUID> {
}