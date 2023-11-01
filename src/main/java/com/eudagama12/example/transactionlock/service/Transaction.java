package com.eudagama12.example.transactionlock.service;

import org.springframework.stereotype.Service;

import com.eudagama12.example.transactionlock.repository.AccountRepository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Transaction {

    private final AccountRepository accountRepository;

    public Transaction(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostConstruct
    public void init() {
        log.info("List of Accounts: {}", accountRepository.findAll().toString());
        
    }
    
}
