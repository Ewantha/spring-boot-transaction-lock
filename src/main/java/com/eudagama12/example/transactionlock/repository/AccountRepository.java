package com.eudagama12.example.transactionlock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eudagama12.example.transactionlock.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    
}
