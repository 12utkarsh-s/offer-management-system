package com.example.offermanagementsystem.dto.offerMetadata.strategyImpl;

import com.example.offermanagementsystem.constant.StrategyType;
import com.example.offermanagementsystem.dto.offerMetadata.ComputationalStrategy;

public class CappedPercentageComputationalStrategy implements ComputationalStrategy {

  private final double cappedAmount;
  private final double benefitMultiplier;

  public CappedPercentageComputationalStrategy(double cappedAmount, double percentage) {
    if (percentage > 100 || percentage < 0) {
      throw new IllegalArgumentException("Percentage not within 0 ot 100");
    }

    this.cappedAmount = cappedAmount;
    this.benefitMultiplier = percentage / 100;
  }

  @Override
  public StrategyType getStrategyType() {
    return StrategyType.FIXED;
  }

  @Override
  public Double computeBenefit(double transactionAmount) {
    double benefitAmount = benefitMultiplier * transactionAmount;
    if (benefitAmount > cappedAmount) {
      benefitAmount = cappedAmount;
    }

    return transactionAmount - benefitAmount;
  }
}
