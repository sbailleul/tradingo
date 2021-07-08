package org.tradingo.common.application.contracts

import org.tradingo.common.domain.Aggregate

interface AggregateRepository<TId, TAggregate> where TAggregate : Aggregate<TId> {
    fun findById(id: TId): TAggregate?
    fun findAll(): List<TAggregate>
    fun save(aggregate: TAggregate): TId
    fun nextId(): TId
    fun remove(id: TId)
}