package org.tradingo.common.application.contracts

import java.util.*

interface PaymentService {
    fun processPayment(id: UUID)
}