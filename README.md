# spring-boot-transaction-lock

This is a sample repository to demonstrate transaction locking in Spring Boot.

## Use Case

User can perform credit and debit transactions using the System.

### Problem

A credit and debit transaction performed at the same time on record is giving us incorrect results.

### Solution

Implement transaction locking. This will not allow operations on record while a transaction is already in progress.

<hr>

## Prerequisites

Build the application using maven.
Connect the application to a database and execute SQL db/db_init.sql

## Code Walkthrough

The application will start from the scheduler which will create two simultaneous transactions