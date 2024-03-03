package com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl;

import com.example.offermanagementsystem.constant.CriteriaType;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.EligibilityCriteria;

public class CityEligibilityCriteria implements EligibilityCriteria {

  private final String validCity;

  public CityEligibilityCriteria(String city) {
    this.validCity = city;
  }

  @Override
  public CriteriaType getCriteriaType() {
    return CriteriaType.SIMPLE;
  }

  @Override
  public boolean isValid(Customer customer, Transaction transaction) {
    return validCity.equalsIgnoreCase(transaction.getCity());
  }
}
