package com.westgate.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.westgate.patient.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}