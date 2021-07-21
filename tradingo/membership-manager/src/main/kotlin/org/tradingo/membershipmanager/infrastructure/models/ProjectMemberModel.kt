package org.tradingo.membershipmanager.infrastructure.models

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "project_member", schema = "members")
class ProjectMemberModel {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    lateinit var id: UUID

    @Type(type = "uuid-char")
    @Column(name = "project_id")
    lateinit var projectId: UUID

    @ManyToOne
    @Type(type = "uuid-char")
    @JoinColumn(name = "member_id")
    lateinit var member: MemberModel

    @Column(name = "join_date")
    lateinit var joinDate: LocalDateTime

    @Column(name = "leave_date")
    var leaveDate: LocalDateTime? = null
}