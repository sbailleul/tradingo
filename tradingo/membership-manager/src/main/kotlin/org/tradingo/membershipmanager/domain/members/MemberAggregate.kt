package org.tradingo.membershipmanager.domain.members

import org.tradingo.common.domain.Aggregate
import org.tradingo.common.domain.members.MemberType
import java.util.*


data class MemberId(val value: UUID)

class MemberAggregate : Aggregate<MemberId> {

    private var _lastname: String
    private var _firstname: String
    private var _password: String
    private var _email: String
    private var _username: String
    private var _type: MemberType
    private var _id: MemberId

    val lastname get() = _lastname
    val firstname get() = _firstname
    val password get() = _password
    val email get() = _email
    val username get() = _username
    val type get() = _type

    private constructor(
        id: MemberId,
        type: MemberType,
        username: String,
        email: String,
        password: String,
        firstname: String,
        lastname: String
    ) {
        _id = id
        _username = username
        _email = email
        _password = password
        _firstname = firstname
        _lastname = lastname
        _type = type
    }

    override val id: MemberId
        get() = _id

    companion object {
        fun createNew(
            id: MemberId,
            type: MemberType,
            username: String,
            email: String,
            password: String,
            firstname: String,
            lastname: String
        ) = MemberAggregate(id, type, username, email, password, firstname, lastname)

        fun restore(
            id: MemberId,
            type: MemberType,
            username: String,
            email: String,
            password: String,
            firstname: String,
            lastname: String
        ) = MemberAggregate(id, type, username, email, password, firstname, lastname)

    }
}

