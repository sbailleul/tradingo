package org.tradingo.marketmanager.presentation

import org.tradingo.common.presentation.input.CloseProjectMessage
import org.tradingo.marketmanager.application.write.CloseProjectCommand

fun CloseProjectMessage.to() = CloseProjectCommand(projectId)