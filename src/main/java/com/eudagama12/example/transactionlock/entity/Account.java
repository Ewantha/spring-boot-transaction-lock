package com.eudagama12.example.transactionlock.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Sample Account Table to store transaction details
 */
@Entity
@Getter
@Setter
@ToString
public class Account {
    
    @Id
    private int id; //Assume this is the account number

    private double amount;

    private Date updateTime;
}
