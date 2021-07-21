package org.tradingo.membershipmanager.application.write.payments

import io.jkratz.mediator.core.Request
import io.jkratz.mediator.core.RequestHandler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.tradingo.common.application.contracts.PaymentService
import org.tradingo.common.application.contracts.TimeService
import org.tradingo.common.domain.DomainException
import org.tradingo.membershipmanager.application.contracts.PaymentRepository
import org.tradingo.membershipmanager.application.contracts.ReadPaymentsRepository
import org.tradingo.membershipmanager.domain.members.PaymentId

class ProcessPaymentCommand() : Request<Unit>

@Component
class ProcessPaymentsCommandHandler(
    private val timeService: TimeService,
    private val paymentRepository: PaymentRepository,
    private val readPaymentsRepository: ReadPaymentsRepository,
    private val paymentService: PaymentService
) : RequestHandler<ProcessPaymentCommand, Unit> {

    private val logger = LoggerFactory.getLogger(ProcessPaymentsCommandHandler::class.java)

    override fun handle(request: ProcessPaymentCommand) {
        readPaymentsRepository.getAllUnacknowledgedPaymentsIdsByDate(timeService.now())
            .map { id ->
                paymentRepository.findById(PaymentId(id)) ?: throw DomainException("Payment $id not found")
            }
            .forEach { payment ->
                try {
                    paymentService.processPayment(payment.id.value)
                    payment.acknowledge(timeService.now())
                    paymentRepository.save(payment)
                } catch (e: Error) {
                    logger.error("An error occured during payment ${payment.id.value} acknowledgement")
                }
            }
    }
}