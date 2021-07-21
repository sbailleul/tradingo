package org.tradingo.genericclient.application.contracts

import org.tradingo.common.application.contracts.Producer
import org.tradingo.common.presentation.input.CloseProjectMessage

interface CloseProjectProducer : Producer<CloseProjectMessage> {
}