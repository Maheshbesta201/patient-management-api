# Patient Management API

A Spring Boot REST API developed for the **Westgate Healthcare Patient Management Platform**.

This project contains the implementation of:

- **T-001 – Patient Management API**
- **T-003 – Clinical Record Service API**

The application provides REST APIs for patient management and clinical record management with database persistence, validation, security, exception handling, audit logging and Swagger/OpenAPI documentation.

---

# Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- REST APIs
- Bean Validation
- Swagger / OpenAPI
- Maven
- Lombok
- Git
- GitHub

---

# T-001 – Patient Management API

## Description

T-001 provides REST APIs for managing patient information using Spring Boot, Spring Data JPA, Hibernate and MySQL.

## Features

- Create patient
- Get all patients
- Get patient by ID
- Update patient
- Delete patient
- MySQL database integration
- JPA/Hibernate persistence
- Request validation
- Exception handling

## Patient Fields

The Patient entity contains:

- Patient ID
- First Name
- Last Name
- Email
- Phone

## Patient API Endpoints

Base URL:

```text
http://localhost:9652