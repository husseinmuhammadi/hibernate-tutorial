package com.javastudio.tutorial.model;

import com.javastudio.tutorial.model.listener.AuditListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Issue_SEQ")
@EntityListeners(AuditListener.class)
public class Issue extends EntityBase implements Auditable {

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
