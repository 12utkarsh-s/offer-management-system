package com.example.offermanagementsystem.request;

import com.example.offermanagementsystem.request.impl.CappedPercentageBenefit;
import com.example.offermanagementsystem.request.impl.FixedAmountBenefit;
import com.example.offermanagementsystem.request.impl.FixedPercentageBenefit;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(callSuper = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FixedAmountBenefit.class, name = "FIXED_AMOUNT"),
        @JsonSubTypes.Type(value = FixedPercentageBenefit.class, name = "FIXED_PERCENTAGE"),
        @JsonSubTypes.Type(
                value = CappedPercentageBenefit.class,
                name = "CAPPED_PERCENTAGE")
})
public abstract class BenefitMetadata {
    private String id;
}
