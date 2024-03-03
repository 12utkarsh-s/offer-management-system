package com.example.offermanagementsystem.repository;

import com.example.offermanagementsystem.dto.Customer;
import com.example.offermanagementsystem.dto.Transaction;
import com.example.offermanagementsystem.dto.offerMetadata.Offer;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class Repository {

  List<Transaction> transactions = new ArrayList<>();
  List<Offer> offers = new ArrayList<>();
  Map<Integer, Customer> customerMap = new HashMap<>();
  Map<Integer, Transaction> customerIdToTransactionMap = new HashMap<>();

  @PostConstruct
  public void init() {
    customerMap.put(1, new Customer(1, 80, new Date(), "Male"));
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
    customerIdToTransactionMap.put(transaction.getCustomerId(), transaction);
  }

  public double getTransactionAmountByWindow(int customerId, int days) {
    return transactions.stream()
        .filter(transaction -> transaction.getCustomerId() == customerId)
        .filter(
            transaction ->
                new Date().getTime() - transaction.getTransactionDate().getTime()
                    > (long) days * 24 * 60 * 60 * 1000)
        .collect(Collectors.summarizingDouble(Transaction::getAmount))
        .getSum();
  }

  public void addOffer(Offer offer) {
    offers.add(offer);
  }

  public List<Offer> getAllOffers() {
    return offers;
  }

  public List<Transaction> getAllTransactions() {
    return transactions;
  }

  public Customer getCustomer(Integer customerId) {
    return customerMap.get(customerId);
  }
}
