package org.tradingo.common.presentation.input;

import lombok.*;
import org.tradingo.common.domain.members.MemberType;

@NoArgsConstructor
@Getter
@Setter
public class AddMemberMessage {

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private MemberType type;
}