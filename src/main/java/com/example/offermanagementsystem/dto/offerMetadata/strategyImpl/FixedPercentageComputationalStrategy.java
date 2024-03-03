package com.example.offermanagementsystem.dto.offerMetadata.strategyImpl;

import com.example.offermanagementsystem.constant.StrategyType;
import com.example.offermanagementsystem.dto.offerMetadata.ComputationalStrategy;

public class FixedPercentageComputationalStrategy implements ComputationalStrategy {

  private final float benefitMultiplier;

  public FixedPercentageComputationalStrategy(int percentage) {
    if (percentage > 100 || percentage < 0) {
      throw new IllegalArgumentException("Percentage not within 0 ot 100");
    }

    this.benefitMultiplier =  percentage / (float) 100;
  }

  @Override
  public StrategyType getStrategyType() {
    return StrategyType.FIXED;
  }

  @Override
  public Double computeBenefit(double transactionAmount) {
    return transactionAmount - benefitMultiplier * transactionAmount;
  }
}
