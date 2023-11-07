package com.eudagama12.example.transactionlock.service;

import com.eudagama12.example.transactionlock.entity.Account;
import com.eudagama12.example.transactionlock.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class Transaction {

    private final AccountRepository accountRepository;

    public Transaction(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostConstruct
    public void init() {
        log.info("List of Accounts: {}", accountRepository.findAll());
    }
    
    // Method to get account
    private Account getAccount(int id) {
        if (!accountRepository.existsById(id)) {
            log.info("Invalid account id: {}", id);
            return null;
        }

        return accountRepository.findById(id).get();
    }

    @Async
    @Transactional
    @SneakyThrows
    @Retryable(retryFor = CannotAcquireLockException.class)
    public void credit(int id, double amount) {
        log.info("Credit Thread: {}", Thread.currentThread().getName());
        Thread.sleep(1000); // Thread sleep will simulate other operations(e.g. validations) occurring in the transaction.

        Account account = getAccount(id);

        if (account == null) return;

        account.setAmount(account.getAmount() + amount);
        account.setUpdateTime(new Date());
        account = accountRepository.save(account);

        log.info("Credit Transaction Completed: {}", account);
    }

    @Async
    @Transactional
    @SneakyThrows
    @Retryable(retryFor = CannotAcquireLockException.class)
    public void debit(int id, double amount) {
        log.info("Debit Thread: {}", Thread.currentThread().getName());
        Thread.sleep(1000); // Thread sleep will simulate other operations(e.g. validations) occurring in the transaction.

        Account account = getAccount(id);

        if (account == null) return;

        account.setAmount(account.getAmount() - amount);
        account.setUpdateTime(new Date());
        account = accountRepository.save(account);

        log.info("Debit Transaction Completed: {}", account);
    }
    
}
