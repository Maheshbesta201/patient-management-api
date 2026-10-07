package com.westgate.patient.audit;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(AuditLogRepository repository) {
        this.repository = repository;
    }

    public void log(
            Authentication authentication,
            String action,
            String resource,
            Long resourceId) {

        AuditLog auditLog = new AuditLog();

        if (authentication != null) {
            auditLog.setUsername(authentication.getName());
        } else {
            auditLog.setUsername("SYSTEM");
        }

        auditLog.setAction(action);
        auditLog.setResource(resource);

        if (resourceId != null) {
            auditLog.setResourceId(resourceId.toString());
        }

        repository.save(auditLog);
    }
}