REM   Script: Activity5
REM   Alter and update

Select *from salesman;

UPDATE salesman SET 
grade = 200 where salesman_city='Rome';

UPDATE salesman SET grade = 300 where salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';


