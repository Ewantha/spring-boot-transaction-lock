-- Active: 1698852634557@@127.0.0.1@3306
CREATE DATABASE bank
    DEFAULT CHARACTER SET = 'utf8mb4';

CREATE TABLE bank.account(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    amount DOUBLE,
    update_time DATETIME COMMENT 'Update Time'
) COMMENT 'Table to store account information';

INSERT INTO bank.`account`(id, amount, update_time) VALUES ('12011996', 400000, NOW());

SELECT * FROM bank.`account`;