
DROP DATATBASE if exists loanApp;
CREATE DATABASE loanApp;

Use loanApp;


CREATE TABLE User(
    uname varchar(20) unique not null primary key,
    pword varchar(20) not null,
    role varchar(20) not null
);

Insert into User values
    ("admin","admin","Admin"),
    ("John","pass1","User");
    

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

CREATE TABLE LoanApplication(

loanAppNum int AUTO_INCREMENT PRIMARY KEY,
loanName varchar(30) NOT NULL,
loanAmt int NOT NULL,
loanAppDate date NOT NULL,
businessStructure varchar(30) NOT NULL,
billingIndicator varchar(30) NOT NULL,
taxIndicator varchar(30) NOT NULL,
address varchar(255) NOT NULL,
email varchar(255) NOT NULL,
mobile int(10) NOT NULL,
status varchar(30)
);

CREATE TABLE LoanSanctioned(
loanAmtSanctioned int NOT NULL,
loanTerm varchar(30) NOT NULL,
payStartDate date NOT NULL,
loanClosureDate date NOT null,
interestRate int NOT NULL,
emi int NOT NULL,
loanAppNum int not null references LoanApplication(loanAppNum),
CONSTRAINT LoanSanctioned_ibfk_1 FOREIGN KEY (loanAppNum) references LoanApplication(loanAppNum) 
);
ALTER TABLE LoanApplication AUTO_INCREMENT = 1000;

INSERT INTO LoanApplication(loanName,loanAmt,loanAppDate,businessStructure,billingIndicator,taxIndicator,address,email,mobile,status) values
("Personal",5679,"2020-09-09","Organization","Salaried","Tax Payer","Hitech","jim@gmail.com",967654490,"submitted");
