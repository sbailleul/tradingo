package org.tradingo.common.application.contracts

interface Producer<TMessage> {
    fun sendMessage(message: TMessage)
}

