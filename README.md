# Employee Management System (Spring Boot + MySQL + Postman)

This project is a Spring Boot REST API for performing CRUD operations on Employee data.  
It uses MySQL for data storage and Postman for testing the APIs.

---

## Features

- Create Employee  
- Read Employee (All, By ID, By First Name)  
- Update Employee (By ID & By First Name)  
- Delete Employee (By ID & By First Name)

---

## Technologies Used

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Postman  

---

---

### Get All Employees  
**GET** `/employee/all`

---

### Get Employee by ID  
**GET** `/employee/id/{id}`

---

### Get Employee by First Name  
**GET** `/employee/name/{firstName}`

---

### Update Employee by ID  
**PUT** `/employee/update/{id}`

---

### Update Employee by First Name  
**PUT** `/employee/updatechar/{firstName}`

---

### Delete Employee by ID  
**DELETE** `/employee/delete/{id}`

---

### Delete Employee by First Name  
**DELETE** `/employee/deleteByName/{firstName}`

---


