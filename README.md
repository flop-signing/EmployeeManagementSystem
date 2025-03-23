# Employee Management System

A **full-stack CRUD application** for managing employees, built using **Spring Boot**, **React**, and **MySQL**.

## Features
- Add new employees
- View employee list
- Update employee details
- Delete employees

## Tech Stack
### Backend
- **Spring Boot** (REST API)
- **Spring Data JPA** (Database interactions)
- **MySQL** (Database)
- **Lombok** (Code reduction)
- **Spring Boot DevTools** (Hot reload)

### Frontend
- **React.js** (User interface)
- **React Router** (Navigation)
- **Tailwind CSS** (Styling)
- **Axios** (API calls)

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/yourusername/employee-management-system.git
cd employee-management-system

cd employeeManagement
mvn clean install
mvn spring-boot:run


spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=yourpassword


cd ../employeemanagementsystem-ui
npm install
npm start

