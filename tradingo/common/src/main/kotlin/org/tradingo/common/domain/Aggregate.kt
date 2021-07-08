package org.tradingo.common.domain

abstract class Aggregate<TId>: Entity<TId>() {
    private val _events = mutableListOf<DomainEvent<TId>>()
    val events get() = _events.toList()

    protected fun registerEvent(domainEvent: DomainEvent<TId>) {
        _events.add(domainEvent)
    }
}