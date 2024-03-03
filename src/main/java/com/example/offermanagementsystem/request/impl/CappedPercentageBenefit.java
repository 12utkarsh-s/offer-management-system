package com.example.offermanagementsystem.request.impl;

import com.example.offermanagementsystem.request.BenefitMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(callSuper = false)
public class CappedPercentageBenefit extends BenefitMetadata {
  private double percentage;
  private double maxLimit;
}
