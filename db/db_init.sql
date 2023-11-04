-- Create database
CREATE DATABASE bank
    DEFAULT CHARACTER SET = 'utf8mb4';

-- Create sample table
CREATE TABLE bank.account(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    amount DOUBLE,
    update_time DATETIME COMMENT 'Update Time'
) COMMENT 'Table to store account information';

-- Delete record if already exist
DELETE FROM bank.`account` WHERE id = 12011995;

-- Insert new record to table
INSERT INTO bank.`account`(id, amount, update_time) VALUES ('12011995', 400000, NOW());

-- View table
SELECT * FROM bank.`account`;