package com.example.offermanagementsystem.dto.offerMetadata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Offer {

    EligibilityCriteria eligibilityCriteria;

    ComputationalStrategy computationalStrategy;
}
