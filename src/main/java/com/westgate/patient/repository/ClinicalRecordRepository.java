package com.westgate.patient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.westgate.patient.entity.ClinicalRecord;

public interface ClinicalRecordRepository
        extends JpaRepository<ClinicalRecord, Long> {

    List<ClinicalRecord> findByPatientIdOrderByRecordDateDesc(Long patientId);
}