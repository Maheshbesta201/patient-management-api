# Patient Management API

A Spring Boot REST API for managing patients and their clinical records.

This project was developed as part of the Westgate Healthcare Patient Management Platform.

## Technologies Used

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
- Git & GitHub

## Database

Database:

`patient_management`

Main tables:

- `patients`
- `clinical_records`
- `audit_logs`

## Features

### Patient Management

- Create patient
- Get patient by ID
- Get all patients
- Update patient
- Delete patient
- Patient validation
- Exception handling

### Clinical Record Service

- Create clinical record
- Get clinical record by ID
- Get clinical records by patient ID
- Update clinical record
- Delete clinical record
- Request validation
- Clinical record not-found handling

### Security

Clinical record APIs are protected using Spring Security HTTP Basic Authentication.

Development users:

- Username: `doctor`
- Password: `Doctor@123`

- Username: `admin`
- Password: `Admin@123`

> These credentials are for development/testing purposes only.

### Audit Logging

The system records clinical record operations in the `audit_logs` table.

Logged operations include:

- CREATE
- READ
- READ_BY_PATIENT
- UPDATE
- DELETE

Each audit entry records:

- Username
- Action
- Resource
- Resource ID
- Timestamp

## Clinical Record API Endpoints

Base URL:

`http://localhost:9652/api/clinical-records`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/clinical-records` | Create clinical record |
| GET | `/api/clinical-records/{id}` | Get clinical record |
| GET | `/api/clinical-records/patient/{patientId}` | Get records for patient |
| PUT | `/api/clinical-records/{id}` | Update clinical record |
| DELETE | `/api/clinical-records/{id}` | Delete clinical record |

## Example Clinical Record Request

```json
{
  "patientId": 1,
  "recordType": "DIAGNOSIS",
  "diagnosis": "Seasonal infection",
  "symptoms": "Fever and cough",
  "treatment": "Medication prescribed",
  "notes": "Follow-up if symptoms persist",
  "recordDate": "2026-10-07"
}