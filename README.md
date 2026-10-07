# Patient Management API

T-001 Patient Management API developed using Spring Boot, MySQL, and REST APIs.

## Project

UK Healthcare Patient Management Platform

## Module

T-001 - Patient Management API

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL
- REST API
- Maven
- Lombok
- Postman
- Git & GitHub

## Features

- Create a new patient
- Get all patients
- Get patient by ID
- Update patient details
- Delete patient
- MySQL database integration
- JPA/Hibernate persistence

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/patients` | Create a patient |
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |

## Patient Fields

- ID
- First Name
- Last Name
- Email
- Phone

## Database

Database Name:

`patient_management`

Table Name:

`patients`

## Project Structure

```text
patient-management-api/
├── src/main/java/com/westgate/patient/
│   ├── controller/
│   │   └── PatientController.java
│   ├── entity/
│   │   └── Patient.java
│   ├── repository/
│   │   └── PatientRepository.java
│   ├── service/
│   │   ├── PatientService.java
│   │   └── PatientServiceImpl.java
│   └── PatientManagementApiApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml