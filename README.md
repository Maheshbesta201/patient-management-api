# Patient Management API

A Spring Boot REST API developed for the Westgate Healthcare Patient Management Platform.

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- Swagger / OpenAPI

## T-001 – Patient Management API

### Description

T-001 implements REST APIs for creating, retrieving, updating, and deleting patient information.

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/patients` | Create patient |
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |

## T-003 – Clinical Record Service API

### Description

T-003 implements REST APIs for managing clinical records associated with patients.

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/clinical-records` | Create clinical record |
| GET | `/api/clinical-records/{id}` | Get clinical record |
| GET | `/api/clinical-records/patient/{patientId}` | Get patient clinical records |
| PUT | `/api/clinical-records/{id}` | Update clinical record |
| DELETE | `/api/clinical-records/{id}` | Delete clinical record |

## Project Structure

```text
patient-management-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/westgate/patient/
│   │   │       ├── audit/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── repository/
│   │   │       └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── .gitignore
└── README.md