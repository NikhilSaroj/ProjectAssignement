# Spring Boot "Customer Reward" Project
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.

## Technology Stack
* Backend : Java, Spring Boot, spring Data JPA
* Database : H2 (in-memory database)
* Build Tool : Maven
* Server : Tomcat

## Prerequisites
* Java 8
* Maven 3.6 or higher
  
## Setup
* Clone this repository 
* Download and extract the project folder.
* Import the project folder in Eclipse editor. (File-> Open projects from File system)
* Locate the diretcory to the project folder.
* After successfull import right click on the project filder. (Run As -> Spring Boot App)</br>
  Note : You will need to install Sring Tool suite(STS) from Help -> Eclipse Market

## Steps to run
* Open the **application.properties** file add:
```
server.port=8765
```
* Right Click on project folder (Run As -> Spring Boot App).
* Check the console tab, if getting the below output means server is running.
```
Initialized JPA EntityManagerFactory for persistence unit 'default'
spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
LiveReload server is running on port 35729
Starting ProtocolHandler ["http-nio-8765"]
Tomcat started on port 8765 (http) with context path ''
Started CustomerRewardPointsApplication in 4.977 seconds (process running for 6.718)
```
* Copy and paset the below URL in browser to access the H2 database, provide username and password as blank then click on Connect.
```
http://localhost:8765/h2-console
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:customer_db
User Name: sa
Password:
```
* Run the below MySQL query to insert Customers Data into Customer table.
```
insert into customer (customer_Id, date_of_birth, email_Id, name)
               values(1, '1998-06-18', 'Nik@gmail.com', 'Nikhil'),
                     (2, '1998-05-05', 'ajit@gmail.com', 'Ajit'),
                     (3, '2000-07-17', 'raj@gmail.com', 'Raj')
```
* Run the below MySQL query to insert Customer Transactions data into CustomerTransaction table.
```
insert into customer_transaction (amount, customer_Id, transact_Date, transact_Id, spent_Details)
                          values (70, 1, '2024-07-13', 1, 'Electronics'),
                                 (200, 2, '2024-07-13', 2, 'Food'),
                                 (300, 3, '2024-07-13', 3, 'Food'),
                                 (60, 1, '2024-08-13', 4, 'Electronics'),
                                 (50, 2, '2024-08-13', 5, 'Food'),
                                 (200, 3, '2024-08-13', 6, 'Food')
```
* Access the API Endpoints in squential order below.
  
## API Endpoints
* For getting all Customer data.
```
http://localhost:8765/reward/customers
```
Reponse:
```
[
    {
        "customerId": 1,
        "emailId": "Nik@gmail.com",
        "name": "Nikhil",
        "dateOfBirth": "1998-06-18"
    },
    {
        "customerId": 2,
        "emailId": "ajit@gmail.com",
        "name": "Ajit",
        "dateOfBirth": "1998-05-05"
    },
    {
        "customerId": 3,
        "emailId": "raj@gmail.com",
        "name": "Raj",
        "dateOfBirth": "2000-07-17"
    }
]
```
* For getting all Customer transactions data.
```
http://localhost:8765/reward/customersTransaction
```
Response:
```
[
    {
        "transactId": 1,
        "customerId": 1,
        "spentDetails": "Electronics",
        "amount": 70,
        "transactDate": "2024-07-13",
        "customer": null
    },
    {
        "transactId": 2,
        "customerId": 2,
        "spentDetails": "Food",
        "amount": 200,
        "transactDate": "2024-07-13",
        "customer": null
    },
    {
        "transactId": 3,
        "customerId": 3,
        "spentDetails": "Food",
        "amount": 300,
        "transactDate": "2024-07-13",
        "customer": null
    },
    {
        "transactId": 4,
        "customerId": 1,
        "spentDetails": "Electronics",
        "amount": 60,
        "transactDate": "2024-08-13",
        "customer": null
    },
    {
        "transactId": 5,
        "customerId": 2,
        "spentDetails": "Food",
        "amount": 50,
        "transactDate": "2024-08-13",
        "customer": null
    },
    {
        "transactId": 6,
        "customerId": 3,
        "spentDetails": "Food",
        "amount": 200,
        "transactDate": "2024-08-13",
        "customer": null
    }
]
```
* For getting all Customer Reward points data.
```
http://localhost:8765/reward/rewardPoints
```
Response:
```
{
    "1": {
        "monthlyPoints": {
            "JULY": 50,
            "AUGUST": 50
        },
        "totalPoints": 100
    },
    "2": {
        "monthlyPoints": {
            "JULY": 250,
            "AUGUST": 50
        },
        "totalPoints": 300
    },
    "3": {
        "monthlyPoints": {
            "JULY": 450,
            "AUGUST": 250
        },
        "totalPoints": 700
    }
}
```
