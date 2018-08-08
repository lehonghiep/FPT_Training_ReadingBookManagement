CREATE DATABASE Book_App
USE Book_App


CREATE TABLE Profiles (
	Profile_ID INT PRIMARY KEY,
	First_Name NVARCHAR(50),
	Last_Name NVARCHAR(50),
	Gender BIT NOT NULL,
	Birth_date DATE,
	Image_Data IMAGE
	);

CREATE TABLE Contact (
	Contact_ID INT PRIMARY KEY,
	Phone VARCHAR(50),
	Email VARCHAR(50)
	);

CREATE TABLE Role (
	Role_ID BIT PRIMARY KEY,
	Authority VARCHAR(50) --describe authority of a role
	);

CREATE TABLE Users (
	ID INT PRIMARY KEY,
	Username VARCHAR(50) UNIQUE,
	Passwords VARCHAR(50),
	Profile_ID INT FOREIGN KEY REFERENCES Profiles(Profile_ID),
	Contact_ID INT FOREIGN KEY REFERENCES Contact(Contact_ID),
	Role_ID BIT NOT NULL FOREIGN KEY REFERENCES Role(Role_ID)
	);

CREATE TABLE Author (
	Author_ID INT PRIMARY KEY,
	Profile_ID INT FOREIGN KEY REFERENCES Profiles(Profile_ID),
	Contact_ID INT FOREIGN KEY REFERENCES Contact(Contact_ID),
	);

CREATE TABLE Publisher(
	Publisher_ID INT PRIMARY KEY,
	Publisher_Name NVARCHAR(50),
	Contact_ID INT FOREIGN KEY REFERENCES Contact(Contact_ID)
	);

CREATE TABLE Category (
	Category_ID INT PRIMARY KEY,
	Category_Name VARCHAR(50)
	);

CREATE TABLE Book (
	Book_ID INT PRIMARY KEY,
	Title VARCHAR(50),
	Brief TEXT,
	Content TEXT,
	Publisher_ID INT FOREIGN KEY REFERENCES Publisher(Publisher_ID),
	Author_ID INT FOREIGN KEY REFERENCES Author(Author_ID),
	Category_ID INT FOREIGN KEY REFERENCES Category (Category_ID)
	);
CREATE TABLE BookCase (
	BookCace_ID INT PRIMARY KEY FOREIGN KEY REFERENCES Users(ID),
	BookCase_Name VARCHAR(50)
	);

create table Contain (
	BookCace_ID INT FOREIGN KEY REFERENCES BookCase(BookCace_ID), 
	Book_ID INT FOREIGN KEY REFERENCES Book(Book_ID),
	CONSTRAINT PK_Contain PRIMARY KEY (BookCace_ID, Book_ID),
	Create_Date DATE
	);


