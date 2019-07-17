package com.javastudio.tutorial.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Task_SEQ")
public class Task extends EntityBase implements History {

    String title;

    String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
