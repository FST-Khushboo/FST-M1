REM   Script: activity9
REM   joins


select a.customer_name AS "Customer name", a.city, b.salesman_name, b.salesman_city, b.commission 
from customers a  
INNER JOIN salesman b 
ON a.salesman_id = b.salesman_id;

select a.customer_name AS "customer name",a.grade,  b.salesman_name, b.salesman_city, b.commission, b.grade  
from customers a 
Left join salesman b 
on a.salesman_id = b.salesman_id 
where a.grade<300 
Order by a.customer_id;

select a.customer_name AS "customer name", b.salesman_name, a.city as "customer city", b.commission 
from customers a 
Inner join salesman b 
on a.salesman_id = b.salesman_id 
where commission >12;

select a.order_no, a.order_date,a.purchase_amount, b.customer_name,b.city, 
c.salesman_name, c.commission 
from orders a 
Inner join customers b On a.customer_id = b.customer_id 
Inner join salesman c ON a.salesman_id = c.salesman_id;

