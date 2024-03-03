package com.example.offermanagementsystem.controller;

import com.example.offermanagementsystem.repository.Repository;
import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

  @Autowired private Repository repository;

  @PostMapping("/create")
  public Boolean createTransaction() {

    Transaction transaction = new Transaction(1, 1, "MName", "MId", "Bangalore", 6000, new Date());

    Customer customer = repository.getCustomer(transaction.getCustomerId());

    List<Offer> eligibleOffers =
        repository.getAllOffers().stream()
            .filter(offer -> offer.getEligibilityCriteria().isValid(customer, transaction))
            .collect(Collectors.toList());

    double newAmount =
        eligibleOffers.stream()
            .map(offer -> offer.getComputationalStrategy().computeBenefit(transaction.getAmount()))
            .sorted()
            .findFirst()
            .get();

    transaction.setAmount(newAmount);

    repository.addTransaction(transaction);
    return true;
  }

  @GetMapping("/getAll")
  public List<Transaction> getAll() {
    return repository.getAllTransactions();
  }
}

