package com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl;

import com.example.offermanagementsystem.constant.CriteriaType;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.EligibilityCriteria;


public class AmountEligibilityCriteria implements EligibilityCriteria {

  private final Integer validAmount;

  public AmountEligibilityCriteria(Integer amount) {
    this.validAmount = amount;
  }

  @Override
  public CriteriaType getCriteriaType() {
    return CriteriaType.SIMPLE;
  }

  @Override
  public boolean isValid(Customer customer, Transaction transaction) {
    return validAmount <= transaction.getAmount();
  }
}
