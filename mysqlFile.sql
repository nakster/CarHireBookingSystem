Create DATABASE CARHIRE;

CREATE TABLE IF NOT EXISTS Customers (
    CustID int NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(255) NOT NULL,
	LastName VARCHAR(255) NOT NULL,
    Mobile VARCHAR(255),
	Country VARCHAR(255),
	Email VARCHAR(255),
    PRIMARY KEY (CustID)
);

CREATE TABLE IF NOT EXISTS CAR(
	CarID int NOT NULL AUTO_INCREMENT,
	CarColour VARCHAR(255) NOT NULL,
	CarBrand VARCHAR(255) NOT NULL,
	CarModel VARCHAR(255) NOT NULL,
	PurchaseDate DATE,
	PRIMARY KEY (CarID)
);

CREATE TABLE IF NOT EXISTS Orders (
    OrderID int NOT NULL AUTO_INCREMENT,
    OrderNumber int NOT NULL,
	Date DATE Not Null,
    CustID int Not Null,
	CarID int Not Null,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID) REFERENCES Customers(CustID),
	FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);


INSERT INTO Customers (FirstName, LastName, Mobile, Country, Email)
VALUES ('Tom','Kelly','0893672867','Ireland','TomKelly@yahoo.ie'),
	   ('John','Kelly','0896757835','Ireland','JohnKelly@yahoo.ie'),
	   ('Mark','Healy','0896757835','Ireland','Mark@gmail.com');

	   
	
INSERT INTO CAR (CarColour, CarBrand, CarModel, PurchaseDate)
VALUES ('Blue','Hyundai I10','I10',CURDATE()),
	   ('red','Ford Fiesta ','Fiesta',CURDATE()),
	   ('white','Hyundai Tucson','Tucson',CURDATE());
	   


INSERT INTO Orders (OrderNumber, Date, CustID, CarID)
VALUES (1234,CURDATE(),1,1),
	   (5678,CURDATE(),2,2),
	   (9101,CURDATE(),3,3);

	   

INSERT INTO Orders (OrderNumber, Date, CustID, CarID)
VALUES (7839,CURDATE(),1,1),
	   (7830,CURDATE(),2,2),
	   (4782,CURDATE(),3,3),
	   (3947,CURDATE(),1,1),
	   (7840,CURDATE(),2,2);

<!--- DELETE FROM Orders WHERE OrderID=1; -->

 

