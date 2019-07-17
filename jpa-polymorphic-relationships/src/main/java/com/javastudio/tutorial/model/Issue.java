package com.javastudio.tutorial.model;

import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Issue_SEQ")
@EntityListeners(AuditListener.class)
public class Issue extends EntityBase implements Auditable {

    String title;


    @Embedded
    private Audit audit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
