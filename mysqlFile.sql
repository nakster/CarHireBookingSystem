Create DATABASE CARHIRE;
use CARHIRE;

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
	Date DATE Not Null,
    CustID int Not Null,
	CarID int Not Null,
	UNIQUE(OrderID),
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
	   


INSERT INTO Orders (Date, CustID, CarID)
VALUES (CURDATE(),1,1),
	   (CURDATE(),2,2),
	   (CURDATE(),3,3);

	   

INSERT INTO Orders (Date, CustID, CarID)
VALUES (CURDATE(),1,1),
	   (CURDATE(),2,2),
	   (CURDATE(),3,3),
	   (CURDATE(),1,1),
	   (CURDATE(),2,2);
	   
select orderid , Date, 
c.CustID,c.FirstName,c.LastName,c.Mobile,c.Country,c.Email,
ca.CarID, ca.CarColour, ca.CarBrand, ca.CarModel, ca.PurchaseDate
FROM Orders
INNER JOIN Customers as c
ON Orders.CustID=c.CustID
INNER JOIN CAR as ca
ON Orders.CarID=ca.CarID ORDER by orderid;


<!--- DELETE FROM Orders WHERE OrderID=1; -->


xjc -d C:\Users\naqia\Desktop\Sarah -p gmit.Model C:\Users\naqia\Desktop\GithubDistributed\github\CarHireBookingSystem\DS\RMI\src\ie\gmit\sw\Model\generateSchema.xsd
 

