package org.tradingo.marketmanager.infrastructure.models

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "project", schema = "projects")
class ProjectModel() {
    @Id
    @Type(type = "uuid-char")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    lateinit var id: UUID

    @Column(name = "start_date")
    lateinit var startDate: LocalDateTime

    @Column(name = "end_date")
    var endDate: LocalDateTime? = null

    @Column(name = "name")
    lateinit var name: String

    @Column(name = "description")
    lateinit var description: String
}