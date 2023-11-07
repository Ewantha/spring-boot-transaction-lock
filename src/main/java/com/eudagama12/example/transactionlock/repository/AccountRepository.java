package com.eudagama12.example.transactionlock.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eudagama12.example.transactionlock.entity.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)    //Add transaction lock
    Optional<Account> findById(Integer integer);
}
