package com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl;

import com.example.offermanagementsystem.constant.CriteriaType;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.EligibilityCriteria;

public class CompositeOrCriteria implements EligibilityCriteria {

  private final EligibilityCriteria lhCriteria;

  private final EligibilityCriteria rhCriteria;

  public CompositeOrCriteria(EligibilityCriteria lhCriteria, EligibilityCriteria rhCriteria) {
    this.lhCriteria = lhCriteria;
    this.rhCriteria = rhCriteria;
  }

  @Override
  public CriteriaType getCriteriaType() {
    return CriteriaType.COMPOSITE;
  }

  @Override
  public boolean isValid(Customer customer, Transaction transaction) {
    return lhCriteria.isValid(customer, transaction) || rhCriteria.isValid(customer, transaction);
  }
}
