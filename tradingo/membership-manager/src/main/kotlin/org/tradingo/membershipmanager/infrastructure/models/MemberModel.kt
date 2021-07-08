package org.tradingo.membershipmanager.infrastructure.models

import org.hibernate.annotations.Type
import org.tradingo.common.domain.members.MemberType
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "member", schema = "members")
class MemberModel() {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    lateinit var id: UUID

    @Column(name = "username") lateinit var username: String
    @Column(name = "email") lateinit var email: String
    @Column(name = "password") lateinit var password: String

    @Column(name = "firstname") lateinit var firstname: String
    @Column(name = "lastname") lateinit var lastname: String


    @Enumerated(EnumType.STRING)
    @Column(name = "type") lateinit var type: MemberType

}