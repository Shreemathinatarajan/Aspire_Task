create database sqlquery;
use sqlquery;
set sql_safe_updates = 0;

create table department(
dept_id int primary key,
dept_name varchar(25)
);
create table Employee(
emp_id int primary key,
emp_name varchar(100),
DOJ date,
salary int,
dept_id int,
Jobtitle varchar(30),
Manager varchar(20),
Location varchar(15),
Email varchar(50),
phone_no long not null,
foreign key (dept_id) references department(dept_id)
);
create table Project(
Project_a boolean,
Project_B boolean,
emp_id int,
foreign key (emp_id) references Employee (emp_id));

insert into department values(1,'HR'),(2,'Development'),(3,'Testing');

insert into Employee values (1,'Priya','2017-10-29',70000,1,'HR','Varun','New York','priya123@gmail.com',9263781928),
(2,'Dhivya','2019-05-15',40000,2,'Automation Tester','Ravi','US','dhivya10@gmail.com',8997785287),
(3,'Saru','2014-09-05',55000,3,'Financial Planner','kavya','Canada',"saru27@gmail.com",9341616938),
(4,'Ram','2023-08-27',25000,2,'Cloud Computing Engineer','Shree','New York','ran2529@gmail.com',9759732873),
(5,'Hari','2015-05-06',26000,1,'HR','Varun','India','hari123@gmail.com',9965316708);

insert into Project values 
(true,false,1),
(true,true,2),
(false,false,3),
(false,true,4),
(false,false,5);

select * from department;
select * from Employee;
select * from Project;

/*Basic Queries*/
/*1*/ select * from Employee as Employee_Data;
/*2*/ select emp_name, salary from Employee;
/*3*/ select emp_name from Employee where salary > 50000;
/*4*/ select emp_Name from Employee where Year(DOJ) = 2019;
/*5*/ select * from Employee where emp_Name like 'A%';
/*Aggregate*/
/*6*/ select avg(salary) as Average_Salary from Employee;
/*7*/ select count(*) as Employee_Count from Employee;
/*8*/ select max(Salary) as Highest_Salary from Employee;
/*9*/ select sum(Salary) as Total_Salary_Paid from Employee;
/*10*/ select dept_id,count(*) as Each_dept_Count from Employee group by dept_id;
/*Joins*/
/*11*/ select e.emp_name,d.dept_name from Employee e inner join department d on d.dept_id = e.dept_id;
/*12*/ select e.emp_name, e2.Manager from Employee e
join Employee e2 ON e2.emp_id=e.emp_id where e2.Manager IS NOT NULL;
/*13*/ select e.emp_name from Employee e join Project p on e.emp_Id = p.emp_Id 
where p.Project_A is not null and p.Project_B is not null;
/*14*/ select e.emp_name, p.Project_A, p.Project_B from Employee e join Project p on e.emp_id = p.emp_id 
where p.Project_A = 1 or p.Project_B = 1 or (p.Project_A = 1 and p.Project_B = 1);
/*15*/ select * from Employee e join Project p on e.emp_id = p.emp_id WHERE p.Project_A is NULL or p.Project_B is NULL;
/*Sub Queries*/ 
/*16*/ select salary from Employee where salary < (select max(salary) from Employee) order by salary desc limit 1;
/*17*/ select e.emp_name from Employee e where e.salary > (select avg(e2.salary) from Employee e2 where  e2.dept_id = e.dept_id group by e2.dept_id);
/*18*/ select emp_name,salary from Employee where salary > (select avg(salary) from Employee);
/*19*/ select d.dept_name, count(e.emp_id) as Employee_Count from Department D join 
Employee e on d.dept_id = e.dept_id group by d.dept_name order by Employee_Count desc limit 1;
/*20*/ select emp_name from Employee where Location in ('New York');
/*Set Operations*/ 
/*21*/ select emp.emp_name,dep.dept_name from Employee emp join 
Department dep on emp.dept_Id = dep.dept_Id where dep.dept_name = 'HR';
/*22*/ select emp.emp_name as Working_On_Two_Projects from Employee emp join 
Project pro on emp.emp_id = pro.emp_id where pro.Project_A = 1 and pro.Project_B = 1;
/*23*/ select emp.emp_name as Not_Working_On_Projects from Employee emp join 
Project pro on emp.emp_id = pro.emp_id where pro.Project_A = 0 and pro.Project_B = 0;
/*24*/ 
create table Former_Employee(
emp_id int primary key,
emp_name varchar(100),
DOJ date,
salary int,
dept_id int,
Jobtitle varchar(30),
Manager varchar(20),
Location varchar(15),
Email varchar(50),
phone_no long not null,
foreign key (dept_id) references department(dept_id)
);
insert into Former_Employee values
(3,'Saru','2014-09-05',55000,3,'Financial Planner','kavya','Canada',"saru27@gmail.com",9341616938),
(5,'Hari','2015-05-06',26000,1,'HR','Varun','India','hari123@gmail.com',9965316708);
/*25*/ select * from Employee union select * from Former_Employee as combined_Table;
/* DML and DDL */
/*26*/ insert into Employee values (6,'Swetha','2024-06-06',20000,3,'Financial Planner','Shreya','India','shalinismile@gmail.com',7678656766);
insert into Project values(true,false,6);
/*27*/ update Employee set salary = (salary*1.10) where dept_id in(select dept_id from department where dept_name = 'IT');
/*28*/ delete from Employee where DOJ <= CURDATE() - INTERVAL 4 YEAR;
/*29*/ create table department_backups(
dept_id int primary key,
dept_name varchar(100));
/*30*/ truncate table Employee;
/*Constraints*/
/*33*/ alter table Employee add constraint unique(Email);
/*34*/ select CONSTRAINT_NAME,CONSTRAINT_TYPE FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS
where TABLE_NAME = 'Employee';
/*35*/ alter table Employee modify column phone_no long;