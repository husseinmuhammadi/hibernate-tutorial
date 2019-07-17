package com.javastudio.tutorial.model.listener;


import com.javastudio.tutorial.model.Audit;
import com.javastudio.tutorial.model.Auditable;
import com.javastudio.tutorial.model.LoggedUser;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if(audit == null) {
            audit = new Audit();
            auditable.setAudit(audit);
        }

        audit.setCreatedOn(LocalDateTime.now());
        audit.setCreatedBy(LoggedUser.get());
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        audit.setUpdatedOn(LocalDateTime.now());
        audit.setUpdatedBy(LoggedUser.get());
    }
}
