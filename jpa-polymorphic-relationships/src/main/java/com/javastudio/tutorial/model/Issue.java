package com.javastudio.tutorial.model;

import org.hibernate.annotations.MetaValue;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Issue_SEQ")
public class Issue extends EntityBase implements History {

    String title;

    String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
