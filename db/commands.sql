

create database mydb;
create table admin(username VARCHAR(20),password VARCHAR(20));
create table teachers(Name VARCHAR(10),Subject VARCHAR(10), Age INT , Course varchar(10));
create table Classes(Name VARCHAR(10),Section VARCHAR(10), Strength INT , CR varchar(10));
create table Subjects(Name VARCHAR(10),Teacher VARCHAR(10), Marks INT );
create table Students(ID INT,Name VARCHAR(10),Course VARCHAR(10), Section VARCHAR(10), Percentage INT );

insert into admin values("admin","password");


insert into teachers values("Srinivas","computer",52,"B.E");
insert into teachers values("RKrishna","Python",42,"BTech");
insert into teachers values("Vaishali","Java",43,"B.E");
insert into teachers values("Praveen","Physics",33,"BTech");

insert into Classes values("CSE ","A",50,"Ramesh");
insert into Classes values("CSE ","C",53,"Suresh");
insert into Classes values("IT ","A",56,"Rahul");
insert into Classes values("CSE ","B",51,"Goutham");

alter table classes add faculty VARCHAR(20);
alter table classes add  subject VARCHAR(20);

insert into Subjects values("Java","Vaishali",75);
insert into Subjects values("DBMS","Srinivas",75);
insert into Subjects values("Python","RKrishna",75);
insert into Subjects values("WIT","Rohith",75);
insert into Subjects values("Physics","Praveen",75);

alter table subjects add class VARCHAR(20);
alter table subjects add section VARCHAR(20);


insert into Students values(1,"Virat","B.E","C",70);
insert into Students values(2,"Somesh","BTech","A",61);
insert into Students values(3,"Arjun","B.E","B",65);
insert into Students values(4,"Vijay","B.E","A",68);
insert into Students values(5,"Mahesh","BTech","B",56);
insert into Students values(6,"Sourav","BTech","C",43);