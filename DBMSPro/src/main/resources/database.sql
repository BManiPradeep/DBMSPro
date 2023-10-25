drop database if exists dbms_proj;
create database dbms_proj;
use dbms_proj;

CREATE TABLE DELIVERYPARTNER (
                                 DriverId bigint AUTO_INCREMENT PRIMARY KEY,
                                 DFname VARCHAR(255),
                                 DLname VARCHAR(255),
                                 Rating FLOAT,
                                 PhoneNo VARCHAR(255)
);
CREATE TABLE ROLE (
                      roleId bigint AUTO_INCREMENT PRIMARY KEY,
                      roleName VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS User (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    fname VARCHAR(255),
    lname VARCHAR(255),
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    roleId bigint default 2,
    city VARCHAR(255),
    street VARCHAR(255),
    pin BIGINT,
    user_type VARCHAR(255),
    dob DATE,
    FOREIGN KEY (roleId) REFERENCES Role(roleId)
    );
CREATE TABLE IF NOT EXISTS Supplier (
    SupplierId bigint PRIMARY KEY AUTO_INCREMENT,
    SupplierName VARCHAR(255),
    PhoneNo VARCHAR(20),
    Email VARCHAR(255),
    UNIQUE(email)
    );
CREATE TABLE PRODUCT (
                         ProductId bigint AUTO_INCREMENT PRIMARY KEY,
                         ProductName VARCHAR(255),
                         ProductDescription VARCHAR(255),
                         Price DECIMAL(10,2),
                         StockQuantity INT,
                         SupplierId bigint,
                         image_path text,
                        FOREIGN KEY (SupplierId) REFERENCES Supplier(SupplierId)
);
# CREATE TABLE ORDERS (
#                         order_id bigint AUTO_INCREMENT PRIMARY KEY,
#                         id bigint,
#                         DriverID bigint,
#                         OrderedDate DATE,
#                         OrderTotal FLOAT,
#                         DeliveredDate DATE,
#                         order_status VARCHAR(255),
#                         FOREIGN KEY (id) REFERENCES USER(id),
#                         FOREIGN KEY (DriverID) REFERENCES DELIVERYPARTNER(DriverID)
# );
# CREATE TABLE PRESCRIPTIONDETAILS (
#                                      PrescriptionId bigint AUTO_INCREMENT PRIMARY KEY,
#                                      order_id bigint,
#                                      PrescriptionDes VARCHAR(255),
#                                      VerificationStatus VARCHAR(255),
#                                      FOREIGN KEY (order_id) REFERENCES ORDERS(order_id)
# );
CREATE TABLE ORDERITEM (
                           ItemId bigint AUTO_INCREMENT PRIMARY KEY,
                           order_id bigint,
                           ProductId bigint,
                           Quantity INT,
                           UnitPrice FLOAT,
                           FOREIGN KEY (order_id) REFERENCES ORDERS(order_id),
                           FOREIGN KEY (ProductId) REFERENCES PRODUCT(ProductId)
);

create table cart_details
(
    user_id bigint ,
    foreign key (user_id) references user(id) on update cascade on delete restrict ,
    prod_id bigint,
    foreign key (prod_id) references product(ProductId) on update cascade on delete restrict,
    primary key (user_id, prod_id),
    prod_quantity int default 1
);

create table employees
(
    emp_id bigint primary key auto_increment,
    emp_fname varchar(20),
    emp_lname varchar(20),
    emp_email varchar(30),
    emp_gender char,
    emp_join_date date
);

create table orders
(
    order_id bigint primary key auto_increment,
    user_id bigint ,
    foreign key (user_id) references user(id) ,
    emp_id bigint default 1,
    foreign key (emp_id) references employees(emp_id) on update cascade on delete restrict,
    order_status varchar(30) default "Order Placed"
);
-- Adding tuples to DELIVERYPARTNER table
INSERT INTO DELIVERYPARTNER (DFname, DLname, Rating, PhoneNo)
VALUES
    ('Driver1Fname', 'Driver1Lname', 4.5, '1234567890'),
    ('Driver2Fname', 'Driver2Lname', 4.2, '2345678901'),
    ('Driver3Fname', 'Driver3Lname', 4.8, '3456789012'),
    ('Driver4Fname', 'Driver4Lname', 4.0, '4567890123'),
    ('Driver5Fname', 'Driver5Lname', 4.7, '5678901234'),
    ('Driver6Fname', 'Driver6Lname', 4.3, '6789012345'),
    ('Driver7Fname', 'Driver7Lname', 4.9, '7890123456'),
    ('Driver8Fname', 'Driver8Lname', 4.1, '8901234567'),
    ('Driver9Fname', 'Driver9Lname', 4.6, '9012345678'),
    ('Driver10Fname', 'Driver10Lname', 4.4, '0123456789');

-- Adding tuples to ROLE table
INSERT INTO ROLE (roleName)
VALUES
    ('ADMIN'),
    ('USER'),
    ('OPERATOR'),
    ('SUPERVISOR'),
    ('MANAGER'),
    ('STAFF'),
    ('GUEST'),
    ('ANALYST'),
    ('DEVELOPER'),
    ('DESIGNER');

-- Adding tuples to User table
INSERT INTO User (fname, lname, username, email, password, roleId, city, street, pin, user_type, dob)
VALUES
    ('John', 'Doe', 'johndoe', 'mani@gmail.com', '12345', 2, 'New York', '123 Main St', 10001, 'USER', '1990-05-15'),
    ('Jane', 'Doe', 'janedoe', 'jane@example.com', 'password2', 2, 'Los Angeles', '456 Oak Ave', 90001, 'USER', '1992-08-21'),
    ('Bob', 'Smith', 'bobsmith', 'bobsmith@example.com', 'password3', 2, 'Chicago', '789 Elm Blvd', 60601, 'USER', '1985-03-10'),
    ('Alice', 'Johnson', 'alicejohnson', 'alicejohnson@example.com', 'password4', 2, 'Houston', '101 Pine Dr', 77001, 'USER', '1988-11-30'),
    ('Mike', 'Brown', 'mikebrown', 'mikebrown@example.com', 'password5', 2, 'San Francisco', '202 Cedar Ln', 94101, 'USER', '1994-06-25'),
    ('Emily', 'Davis', 'emilydavis', 'emilydavis@example.com', 'password6', 2, 'Miami', '303 Birch Ct', 33101, 'USER', '1987-12-12'),
    ('Chris', 'Taylor', 'christaylor', 'christaylor@example.com', 'password7', 2, 'Seattle', '404 Maple Ave', 98101, 'USER', '1991-09-05'),
    ('Sarah', 'Wilson', 'sarahwilson', 'sarahwilson@example.com', 'password8', 2, 'Boston', '505 Oak St', 02101, 'USER', '1989-04-18'),
    ('David', 'Clark', 'davidclark', 'davidclark@example.com', 'password9', 2, 'Atlanta', '606 Pine Blvd', 30301, 'USER', '1993-07-08'),
    ('Laura', 'Anderson', 'lauraanderson', 'lauraanderson@example.com', 'password10', 2, 'Dallas', '707 Elm Dr', 75201, 'USER', '1986-02-28');

-- Adding tuples to Supplier table
INSERT INTO Supplier (SupplierName, PhoneNo, Email)
VALUES
    ('Supplier1', '1234567890', 'supplier1@example.com'),
    ('Supplier2', '2345678901', 'supplier2@example.com'),
    ('Supplier3', '3456789012', 'supplier3@example.com'),
    ('Supplier4', '4567890123', 'supplier4@example.com'),
    ('Supplier5', '5678901234', 'supplier5@example.com'),
    ('Supplier6', '6789012345', 'supplier6@example.com'),
    ('Supplier7', '7890123456', 'supplier7@example.com'),
    ('Supplier8', '8901234567', 'supplier8@example.com'),
    ('Supplier9', '9012345678', 'supplier9@example.com'),
    ('Supplier10', '0123456789', 'supplier10@example.com');

# -- Adding tuples to PRESCRIPTIONDETAILS table
# INSERT INTO PRESCRIPTIONDETAILS (order_id, PrescriptionDes, VerificationStatus)
# VALUES
#     (1, 'Prescription for Order 1', 'Verified'),
#     (2, 'Prescription for Order 2', 'Pending'),
#     (3, 'Prescription for Order 3', 'Verified'),
#     (4, 'Prescription for Order 4', 'Pending'),
#     (5, 'Prescription for Order 5', 'Verified'),
#     (6, 'Prescription for Order 6', 'Pending'),
#     (7, 'Prescription for Order 7', 'Verified'),
#     (8, 'Prescription for Order 8', 'Pending'),
#     (9, 'Prescription for Order 9', 'Verified'),
#     (10, 'Prescription for Order 10', 'Pending');

-- Adding tuples to ORDERITEM table
# INSERT INTO ORDERITEM (order_id, ProductId, Quantity, UnitPrice)
# VALUES
#     (1, 1, 2, 10.0),
#     (2, 2, 3, 15.0),
#     (3, 3, 4, 20.0),
#     (4, 4, 5, 25.0),
#     (5, 5, 6, 30.0),
#     (6, 6, 7, 35.0),
#     (7, 7, 8, 40.0),
#     (8, 8, 9, 45.0),
#     (9, 9, 10, 50.0),
#     (10, 10, 11, 55.0);
INSERT INTO product (ProductName, ProductDescription, Price, StockQuantity, SupplierId, image_path)
VALUES ('Product1', 'Description1', 10.00, 100, 1,  'path1.jpg'),
       ('Product2', 'Description2', 20.00, 200, 2, 'path2.jpg');

-- Add more INSERT statements for the remaining 8 products
