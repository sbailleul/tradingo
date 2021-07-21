package org.tradingo.common.presentation.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tradingo.common.domain.members.MemberType;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class CloseProjectMessage {
    private UUID projectId;
}