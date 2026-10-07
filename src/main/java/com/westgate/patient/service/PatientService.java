package com.westgate.patient.service;

import java.util.List;

import com.westgate.patient.entity.Patient;

public interface PatientService {

    Patient createPatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}