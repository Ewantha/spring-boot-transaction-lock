package com.eudagama12.example.transactionlock.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eudagama12.example.transactionlock.entity.Account;
import com.eudagama12.example.transactionlock.repository.AccountRepository;
import com.eudagama12.example.transactionlock.service.Transaction;

@Service
public class TransactionScheduler {

    private final Transaction transaction;

    public TransactionScheduler(Transaction transaction) {
        this.transaction = transaction;
    }

    // Scheduler will create two transactions occuring at the same time.
    @Scheduled(fixedDelay = 60000)
    public void init() {
        transaction.credit(12011995, 20000);
        transaction.debit(12011995, 20000);
    }    
}
