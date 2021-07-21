package org.tradingo.membershipmanager.presentation

import io.jkratz.mediator.core.Mediator
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.tradingo.common.presentation.scheduling.Scheduler
import org.tradingo.membershipmanager.application.write.payments.ProcessPaymentCommand

@Service
@EnableScheduling
class PaymentScheduler(private val mediator: Mediator) : Scheduler {

    @Scheduled(cron = "0 0 0 ? * * *")
    override fun process() {
        mediator.dispatch(ProcessPaymentCommand())
    }

}