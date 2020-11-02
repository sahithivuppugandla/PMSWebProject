 CREATE DATABASE PMS;
 USE PMS;
 
CREATE TABLE UserLogin(
 
		username varchar(50) unique not null primary key,
        password varchar(20) not null,
        role varchar(40) not null
);

CREATE TABLE companyIPO(

        company_code int NOT NULL PRIMARY KEY,
          company_title varchar(50) NOT NULL,
          operations varchar(50) NOT NULL,
          share_count int NOT NULL,
          open_share_price decimal(10,4) NOT NULL,
          sector varchar(50) NOT NULL,
          currency varchar(15) NOT NULL,
          turnover int NOT NULL 
     );
     
     insert into companyIPO values
     (101,"TCS","Software","4567","56.7","IT","USD","987868765"),
      (102,"WELSPUN","Electrical","989","23.7","Power","USD","868689");

CREATE TABLE stock_prices(
    stock_exchange varchar(20) NOT NULL UNIQUE PRIMARY KEY,
    current_price int NOT NULL,
    date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    company_code int,
    FOREIGN KEY(company_code) REFERENCES companyIPO(company_code)
);




CREATE TABLE commodities(
    com_item varchar(20),
    price decimal(10,4) not null ,
    updateddate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    check(price>=0)
);

CREATE TABLE investor(
    investor_name varchar(50) not null,
    email varchar(60) not null,
    phone int not null,
    address varchar(100),
    pan_id varchar(30) not null primary key,
    amt_invested decimal(10,4),
    portfolio_val decimal(10,4),
    comp_code int not null,
    company_code int not null references companyIPO(company_code)
);

CREATE TABLE PortfolioWallet(
    current_amt double, not null,
    amt_withdrawn double,
    amt_deposited double
);

CREATE TABLE User(
 	id  int(3) NOT NULL AUTO_INCREMENT primary key,
	username varchar(50) unique not null,
         password varchar(20) not null,
        role varchar(20) not null
);



CREATE TABLE SuperUser(
	superusername varchar(50) unique not null,
    email varchar(20) not null,
    bor_uname varchar(50) not null,
    bor_pword varchar(8) not null
);

INSERT INTO UserLogin values
("John","pass1","Admin"),
("Shweta","pass2","Investor"),
("Maria","pass3","Investor"),
("Jim","pass4","Admin"),
("Rupal","pass5","Back Office Representative"),
("Ted","pass6","Back Office Representative");
