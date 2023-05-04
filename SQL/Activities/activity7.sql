REM   Script: Activity7
REM   Aggregate operations using the set operators.

SELECT SUM(purchase_amount) AS TOTAL_PURCHASE_AMOUNT FROM orders;

SELECT AVG(purchase_amount) AS average_purchase_amount  FROM orders;

SELECT MAX(purchase_amount) AS maximum_purchase_amount FROM orders;

SELECT MIN(purchase_amount) AS minimum_purchase_amount FROM orders;

SELECT COUNT(purchase_amount) AS number_of_salesmen FROM orders;

