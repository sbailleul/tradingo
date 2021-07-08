package org.tradingo.genericclient.application.contracts

import org.tradingo.common.application.contracts.KafkaProducer
import org.tradingo.common.presentation.input.AddMemberMessage

interface AddMemberProducer : KafkaProducer<AddMemberMessage> {

}