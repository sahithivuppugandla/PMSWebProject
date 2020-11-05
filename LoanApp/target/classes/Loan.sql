CREATE DATABASE loanApp;

Use loanApp;


CREATE TABLE User(
    uname varchar(20) not null primary key,
    pword varchar(20) not null
);

Insert into User values
    ("admin","admin");

CREATE TABLE LoanInfo(
    Applno varchar(20) not null primary key,
    purpose varchar(20),
    amtrequest int,
    doa date,
    bstructure varchar(30),
    bindicator varchar(30),
    caddress varchar(100),
    email varchar(100),
    mobile varchar(10),
    status varchar(20)
);