package com.eudagama12.example.transactionlock.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eudagama12.example.transactionlock.entity.Account;
import com.eudagama12.example.transactionlock.repository.AccountRepository;
import com.eudagama12.example.transactionlock.service.Transaction;

@Service
public class TransactionScheduler {

    private final Transaction transaction;

    private static final int ACCOUNT_NUMBER = 12011995;     // Transaction occurring account number

    public TransactionScheduler(Transaction transaction) {
        this.transaction = transaction;
    }

    // Scheduler will create two transactions occurring at the same time.
    @Scheduled(fixedDelay = 60000)
    public void init() {
        transaction.credit(ACCOUNT_NUMBER, 20000);    // Simulate credit transaction
        transaction.debit(ACCOUNT_NUMBER, 20000);     // Simulate debit transaction
    }    
}
