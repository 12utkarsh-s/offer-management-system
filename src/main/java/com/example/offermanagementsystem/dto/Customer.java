package com.example.offermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Customer {

    int customerId;

    Integer age;

    Date dateOfBirth;

    String gender;
}
