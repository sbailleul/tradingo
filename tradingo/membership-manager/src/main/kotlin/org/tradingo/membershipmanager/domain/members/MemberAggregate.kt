package org.tradingo.membershipmanager.domain.members

import org.tradingo.common.domain.Aggregate
import org.tradingo.common.domain.members.MemberType
import org.tradingo.common.domain.projects.ProjectId
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
    private var _projects = mutableListOf<ProjectEntity>()

    val lastname get() = _lastname
    val firstname get() = _firstname
    val password get() = _password
    val email get() = _email
    val username get() = _username
    val type get() = _type
    val projects get() = _projects

    private constructor(
        id: MemberId,
        type: MemberType,
        username: String,
        email: String,
        password: String,
        firstname: String,
        lastname: String,
        projects: List<ProjectEntity>
    ) {
        _id = id
        _username = username
        _email = email
        _password = password
        _firstname = firstname
        _lastname = lastname
        _type = type
        _projects = projects.toMutableList()
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
        ) = MemberAggregate(id, type, username, email, password, firstname, lastname, listOf())

        fun restore(
            id: MemberId,
            type: MemberType,
            username: String,
            email: String,
            password: String,
            firstname: String,
            lastname: String,
            projects: List<ProjectEntity>
        ) = MemberAggregate(id, type, username, email, password, firstname, lastname, projects)
    }

    fun leaveProject(projectId: ProjectId) {
        projects.removeIf { it.id == projectId }
    }
}

