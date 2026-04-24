# 🚀 Employee Management REST API


## 📌 Overview

A backend **Spring Boot REST API** for managing employees with **Pagination, Sorting, and Search** functionality.
Built using clean architecture and industry-standard practices.

---

## 🔥 Features

* ✅ Employee CRUD APIs
* ✅ Server-side Pagination
* ✅ Sorting (ASC / DESC)
* ✅ Search functionality
* ✅ DTO & Mapper Pattern
* ✅ Global Exception Handling
* ✅ Clean layered architecture

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok

---

## 📂 Project Structure

```
src/main/java/com/pagination/sorting
├── controller
│   └── EmployeeController.java
├── service
│   ├── EmployeeService.java
│   └── EmployeeServiceImpl.java
├── repository
│   └── EmployeeRepository.java
├── entity
│   └── Employee.java
├── dto
│   ├── EmployeeDto.java
│   └── PageResponse.java
├── mapper
│   └── EmployeeMapper.java
└── exception
    └── GlobalExceptionHandler.java

src/main/resources
└── application.properties
```

```

---

## 🔗 API Endpoints

### 👉 Get Employees (Pagination + Sorting + Search)

GET /api/employees?page=0&size=5&sortField=name&sortDir=asc&keyword=rahul

---

### 👉 Create Employee

POST /api/employees

---

### 👉 Update Employee

PUT /api/employees/{id}

---

### 👉 Delete Employee

DELETE /api/employees/{id}

---

## 📊 Sample Response

```json id="0gacrs"
{
  "content": [
    {
      "id": 1,
      "name": "Amit Kumar",
      "email": "amit@example.com",
      "department": "IT"
    }
  ],
  "page": 0,
  "size": 5,
  "totalElements": 50,
  "totalPages": 10
}
```

---

## ▶️ How to Run

1. Clone repository
   git clone https://github.com/pradeep4684/your-repo.git

2. Configure database in application.properties

3. Run Spring Boot application

4. Test APIs using Postman:
   http://localhost:8080/api/employees

---

## 🧠 Architecture

Controller → Service → Repository → Database -> DTO ↔ Mapper ↔ Entity

---

## 👨‍💻 Author

**Pradeep Andhale**

---

⭐ If you like this project, give it a star!

