create database travelmanagementsystem;
use travelmanagementsystem;

create table account (
username varchar(50),
name varchar(50),
password varchar(50),
question varchar(50),
answer varchar(50)
);

show tables;
select * from account;

create table customer(
username varchar(50),
id  varchar(30),
number varchar(30),
name varchar(50),
gender varchar(20),
country varchar(30),
address varchar(100),
phone varchar(20),
email varchar(40));

select * from customer;


create table bookPackage(
username varchar(50),
packa  varchar(30),
person varchar(30),
id varchar(50),
number varchar(20),
phone varchar(30),
price varchar(100)
);

select * from bookPackage;


create table bookHotel(
username varchar(50),
hotelName varchar(50),
person varchar(30),
days varchar(10),
ac varchar(20),
food varchar(30),
id varchar(30),
number varchar(20),
phone varchar(20),
price varchar(100)
);


create table hotel(
name varchar(100),
cost varchar(10),
roomType varchar(10),
foodIncluded varchar(10)
);

select * from hotel;

insert into hotel (name, cost ,roomType,foodIncluded ) values ('Raddison Blue Hotel', 3400,1000,1700);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('River View Hotel', 3600,1100,1800);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('JW Marriott Hotel', 2400,1200,1900);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Mandarin Oriental Hotel', 3200,1500,2000);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Four Seasons Hotel', 3900,1400,1800);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Classio Hotel', 2300,1100,1500);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('The Bay Club Hotel', 3500,1200,1900);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Breeze Blow', 3300,1300,1400);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Happy Morning Hotel', 2900,1300,1800);
insert into hotel (name, cost ,roomType,foodIncluded ) values ('Snow Point Hotel', 3000,1100,1700);