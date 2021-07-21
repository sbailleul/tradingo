package org.tradingo.common.presentation.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PaymentInfo {
    private Double amount;
    private Long frequencyMs;
}
