package org.tradingo.common.presentation.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class LeaveProjectMessage {
    private UUID projectId;
}