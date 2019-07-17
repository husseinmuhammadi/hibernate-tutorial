package com.javastudio.tutorial.model;

import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Task_SEQ")
@EntityListeners(AuditListener.class)
public class Task extends EntityBase implements Auditable {

    String title;

    String status;

    @Embedded
    private Audit audit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
