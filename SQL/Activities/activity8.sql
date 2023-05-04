REM   Script: Activity8
REM   Aggregate operations using the set operators.

SELECT customer_id, MAX(purchase_amount) AS Amount 
from orders 
Group by customer_id;

SELECT salesman_id,order_date, MAX(purchase_amount) AS Amount 
from orders where order_date=TO_DATE ('2012-08-17','YYYY/MM/DD') 
Group by salesman_id,order_date;

select customer_id,order_date,  MAX(purchase_amount) AS Amount from orders 
Group by customer_id,order_date  
   Having Max(purchase_amount) IN (2030, 3450, 5760, 6000);

