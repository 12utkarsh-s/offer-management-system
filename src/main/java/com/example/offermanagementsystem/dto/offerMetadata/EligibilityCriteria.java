package com.example.offermanagementsystem.dto.offerMetadata;

import com.example.offermanagementsystem.constant.CriteriaType;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;

public interface EligibilityCriteria {

    CriteriaType getCriteriaType();

    boolean isValid(Customer customer, Transaction transaction);
}
