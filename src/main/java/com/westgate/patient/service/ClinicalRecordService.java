package com.westgate.patient.service;

import java.util.List;

import com.westgate.patient.dto.ClinicalRecordRequest;
import com.westgate.patient.entity.ClinicalRecord;

public interface ClinicalRecordService {

    ClinicalRecord create(
            ClinicalRecordRequest request,
            String username);

    ClinicalRecord getById(Long id);

    List<ClinicalRecord> getByPatientId(Long patientId);

    ClinicalRecord update(
            Long id,
            ClinicalRecordRequest request,
            String username);

    void delete(Long id);
}