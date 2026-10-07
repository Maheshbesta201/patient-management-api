package com.westgate.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westgate.patient.dto.ClinicalRecordRequest;
import com.westgate.patient.entity.ClinicalRecord;
import com.westgate.patient.exception.ClinicalRecordNotFoundException;
import com.westgate.patient.repository.ClinicalRecordRepository;

@Service
@Transactional
public class ClinicalRecordServiceImpl
        implements ClinicalRecordService {

    private final ClinicalRecordRepository repository;

    public ClinicalRecordServiceImpl(
            ClinicalRecordRepository repository) {

        this.repository = repository;
    }

    @Override
    public ClinicalRecord create(
            ClinicalRecordRequest request,
            String username) {

        ClinicalRecord record = new ClinicalRecord();

        copyData(request, record);

        record.setCreatedBy(username);
        record.setUpdatedBy(username);

        return repository.save(record);
    }

    @Override
    @Transactional(readOnly = true)
    public ClinicalRecord getById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                    () -> new ClinicalRecordNotFoundException(id)
                );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClinicalRecord> getByPatientId(
            Long patientId) {

        return repository
                .findByPatientIdOrderByRecordDateDesc(patientId);
    }

    @Override
    public ClinicalRecord update(
            Long id,
            ClinicalRecordRequest request,
            String username) {

        ClinicalRecord record = getById(id);

        copyData(request, record);

        record.setUpdatedBy(username);

        return repository.save(record);
    }

    @Override
    public void delete(Long id) {

        ClinicalRecord record = getById(id);

        repository.delete(record);
    }

    private void copyData(
            ClinicalRecordRequest request,
            ClinicalRecord record) {

        record.setPatientId(request.getPatientId());
        record.setRecordType(request.getRecordType());
        record.setDiagnosis(request.getDiagnosis());
        record.setSymptoms(request.getSymptoms());
        record.setTreatment(request.getTreatment());
        record.setNotes(request.getNotes());
        record.setRecordDate(request.getRecordDate());
    }
}