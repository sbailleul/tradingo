package org.tradingo.common.domain

abstract class DomainEvent<TId>(val aggregateId: TId) {

}