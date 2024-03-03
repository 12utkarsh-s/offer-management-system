package com.example.offermanagementsystem.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class OfferRequest {

    BenefitMetadata benefitMetadata;

    EligibilityMetadata eligibilityMetadata;
}
