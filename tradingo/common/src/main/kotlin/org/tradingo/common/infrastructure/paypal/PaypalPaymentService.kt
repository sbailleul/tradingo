package org.tradingo.common.infrastructure.paypal

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.tradingo.common.application.contracts.PaymentService
import java.util.*

@Service
class PaypalPaymentService : PaymentService {
    private val logger = LoggerFactory.getLogger(PaypalPaymentService::class.java)
    override fun processPayment(id: UUID) {
        logger.info("Fake payment $id proceed")
    }
}