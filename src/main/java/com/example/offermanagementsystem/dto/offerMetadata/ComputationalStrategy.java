package com.example.offermanagementsystem.dto.offerMetadata;

import com.example.offermanagementsystem.constant.StrategyType;

public interface ComputationalStrategy {

    StrategyType getStrategyType();

    Double computeBenefit(double transactionAmount);
}
