package com.example.offermanagementsystem.dto.offerMetadata.criteriaImpl;

import com.example.offermanagementsystem.repository.Repository;
import com.example.offermanagementsystem.constant.CriteriaType;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.EligibilityCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AccumulatingEligibilityCriteria implements EligibilityCriteria {

    private Repository repository;

    private final int windowInDays;
    private final double amount;

    AccumulatingEligibilityCriteria(int window, double amount) {
        this.windowInDays = window;
        this.amount = amount;
    }

    @Override
    public CriteriaType getCriteriaType() {
        return CriteriaType.ACCUMULATING;
    }

    @Override
    public boolean isValid(Customer customer, Transaction transaction) {
        double totalTransaction = repository.getTransactionAmountByWindow(customer.getCustomerId(), windowInDays);
        return totalTransaction + transaction.getAmount() >= amount;
    }
}
