# spring-boot-transaction-lock

This is a sample repository to demonstrate transaction locking in Spring Boot.

## Use Case

User can perform credit and debit transactions using the System.

### Problem

A credit and debit transaction performed at the same time on record is giving us incorrect results.

### Solution

Implement transaction locking. This will not allow operations on record while a transaction is already in progress.
This will fix anytype of simultaneous transactions giving incorrect results.

<hr>

## Prerequisites

- Require a SQL database (E.g. localhost)
- Execute SQL in db/db_init.sql
- Update datasource configuration in application.properties and connect the application to the database.

## Code Walkthrough

- The flow will be initiated from the scheduler which will create two simultaneous transactions.
- Application is designed as a multithreaded application and will run credit and/or debit operations asynchronously.
- Pessimistic read lock will lock the record for read operations until the transaction is completed.
- Any transaction attempting to read the record while locked will throw CannotAcquireLockException.
- Spring Retry is used to retry methods throwing CannotAcquireLockException.