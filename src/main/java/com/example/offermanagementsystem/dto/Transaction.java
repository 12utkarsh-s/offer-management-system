package com.example.offermanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Transaction {

    int id;

    int customerId;

    String merchantName;

    String merchantId;

    String city;

    @Setter
    double amount;

    Date transactionDate;
}
