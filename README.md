# Railway Management System

A RESTful API built with Spring Boot to manage trains, stations, and tickets in a railway management system. The API provides endpoints for creating, reading, updating, and deleting (CRUD) operations with secure access using Spring Security.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Authentication](#authentication)
- [Validation Rules](#validation-rules)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
---

## Features
- **CRUD Operations** for trains, stations, and tickets.
- **Basic Authentication** for secure API access.
- **Data Validation** for resource integrity.
- **Swagger Integration** for API documentation.
- **RESTful Design** adhering to best practices.

---

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for application development.
- **Spring Data JPA**: Database interaction.
- **Spring Security**: Authentication and authorization.
- **H2**: Database.
- **Swagger/OpenAPI**: API documentation.
- **Jakarta Validation**: Input validation.

---

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git
- H2 database

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Ksengnupan/spring-boot-assessment.git
   cd spring-boot-assessment
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Usage

#### Endpoints
The API provides the following endpoints:

- `/api/trains` - CRUD operations for trains
- `/api/stations` - CRUD operations for stations
- `/api/tickets` - CRUD operations for tickets

#### Authentication
The API uses user-password based authentication. You need to provide a username and password to access the endpoints, and ONLY the authenticaled credential will be accessible.

### Validation Rules
The API uses Jakarta Validation for input validation. Ensure that your requests adhere to the validation rules defined in the application.

### API Documentation
The API documentation is available at `/swagger-ui.html` once the application is running. It provides detailed information about the available endpoints and their usage.

### Database Schema
The application uses an H2 in-memory database. The database schema is automatically created and managed by Spring Data JPA.
