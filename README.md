# Student Management System - Backend

This is the **backend service** for the Student Management System built using **Java, Spring Boot, and MySQL**.  
It provides RESTful APIs to manage student records including creating, updating, deleting, searching, and retrieving students.

## 🚀 Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs

## 📌 Features

- Add new student records
- View all students
- Update student information
- Delete student records
- Search students by different fields
- RESTful API architecture
- MySQL database integration

## 📂 Project Structure
src
│
├── controller
├── service
├── repository
├── model
└── StudentManagementApplication.java

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository


git clone https://github.com/sourabhrajput2004/student-management-backend.git


### 2️⃣ Configure Database

Update **application.properties**


spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword


### 3️⃣ Run the Application


mvn spring-boot:run


Server will start on:


http://localhost:8080


## 📡 API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /students | Get all students |
| POST | /students | Add new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |
| GET | /search | Search students |

## 🌐 Deployment

Backend deployed on **Render** 

## 👨‍💻 Author

Sourabh Singh
