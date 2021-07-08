package org.tradingo.membershipmanager.application.contracts

import org.tradingo.common.application.contracts.AggregateRepository
import org.tradingo.membershipmanager.domain.members.MemberAggregate
import org.tradingo.membershipmanager.domain.members.MemberId

interface MemberRepository : AggregateRepository<MemberId, MemberAggregate> {

}