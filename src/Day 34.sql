create database payroll_service;
show databases;
use payroll_service;
create table employee_payroll(
id int unsigned auto_increment primary key,
name varchar(150),
salary double,
startDate date);
desc employee_payroll;
insert into employee_payroll (name,salary,startDate) values
("Parag",10000,'2000-10-24')
,("Megha",8000,'2004-08-04')
, ("Shreya",18000,'2002-02-12')
,("Sourav", 20000,'2000-06-04')
,("Nishant", 14000, '2001-08-05');
select * from employee_payroll;
select salary from employee_payroll where name="Shreya";
select name from employee_payroll 
WHERE startDate BETWEEN CAST('2000-01-01'
AS DATE) AND DATE(NOW());
ALTER TABLE employee_payroll
  ADD gender char(1) NOT NULL
    AFTER name;
select * from employee_payroll;
use payroll_service;
UPDATE employee_payroll set gender ='M' 
where id = 1 or id =
4 or id = 5;
UPDATE employee_payroll set gender ='F' 
where id = 2 or id =
3;
select * from employee_payroll;
SELECT SUM(salary) FROM employee_payroll
WHERE gender = 'F' GROUP BY gender;

Alter table employee_payroll ADD phone varchar(10), ADD department varchar(50) not null, 
 ADD address varchar(250) default "TBD";
 
 select * from employee_payroll;
Alter table employee_payroll DROP column address;
Alter table employee_payroll add address varchar(500) default "TBD";
select * from employee_payroll;
Alter table employee_payroll 
add  basic_pay double, add deductions double, 
add taxable_pay double, add income_tax double, 
add net_pay double;
use payroll_service;
select * from employee_payroll;
insert into employee_payroll(
name, gender, startDate, phone, department, address, 
basic_pay, deductions, taxable_pay, income_tax, net_pay) values
('Terissa', 'F', '2000-01-01', '8837657909', 'Sales and Marketing', 'Mumbai', 8000, 200,7800,300,7500),
('Terissa', 'F', '2020-10-22', '7878787878', 'HR', 'Mumbai', 20000, 2000,1000,200,1800);
select * from employee_payroll;
SELECT COUNT(salary) FROM employee_payroll WHERE gender = 'F' GROUP BY gender;