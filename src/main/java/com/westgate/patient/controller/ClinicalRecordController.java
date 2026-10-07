package com.westgate.patient.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.westgate.patient.audit.AuditLogService;
import com.westgate.patient.dto.ClinicalRecordRequest;
import com.westgate.patient.entity.ClinicalRecord;
import com.westgate.patient.service.ClinicalRecordService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/clinical-records")
@SecurityRequirement(name = "basicAuth")
public class ClinicalRecordController {

    private final ClinicalRecordService service;

    private final AuditLogService auditLogService;

    public ClinicalRecordController(
            ClinicalRecordService service,
            AuditLogService auditLogService) {

        this.service = service;
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecord> create(
            @Valid @RequestBody ClinicalRecordRequest request,
            Authentication authentication) {

        ClinicalRecord record =
                service.create(
                        request,
                        authentication.getName());

        auditLogService.log(
                authentication,
                "CREATE",
                "ClinicalRecord",
                record.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(record);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalRecord> getById(
            @PathVariable Long id,
            Authentication authentication) {

        ClinicalRecord record = service.getById(id);

        auditLogService.log(
                authentication,
                "READ",
                "ClinicalRecord",
                id);

        return ResponseEntity.ok(record);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ClinicalRecord>> getByPatientId(
            @PathVariable Long patientId,
            Authentication authentication) {

        List<ClinicalRecord> records =
                service.getByPatientId(patientId);

        auditLogService.log(
                authentication,
                "READ_BY_PATIENT",
                "ClinicalRecord",
                patientId);

        return ResponseEntity.ok(records);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecord> update(
            @PathVariable Long id,
            @Valid @RequestBody ClinicalRecordRequest request,
            Authentication authentication) {

        ClinicalRecord record =
                service.update(
                        id,
                        request,
                        authentication.getName());

        auditLogService.log(
                authentication,
                "UPDATE",
                "ClinicalRecord",
                id);

        return ResponseEntity.ok(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            Authentication authentication) {

        service.delete(id);

        auditLogService.log(
                authentication,
                "DELETE",
                "ClinicalRecord",
                id);

        return ResponseEntity.noContent().build();
    }
}