package com.example.offermanagementsystem.dto.offerMetadata.strategyImpl;

import com.example.offermanagementsystem.constant.StrategyType;
import com.example.offermanagementsystem.dto.offerMetadata.ComputationalStrategy;

public class FixedAmountComputationalStrategy implements ComputationalStrategy {

  private final int benefitAmount;

  public FixedAmountComputationalStrategy(int benefitAmount) {
    this.benefitAmount = benefitAmount;
  }

  @Override
  public StrategyType getStrategyType() {
    return StrategyType.FIXED;
  }

  @Override
  public Double computeBenefit(double transactionAmount) {
    if (transactionAmount < benefitAmount) {
      return 0.0;
    }
    return transactionAmount - benefitAmount;
  }
}
