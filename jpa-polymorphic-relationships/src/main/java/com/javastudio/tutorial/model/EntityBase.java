package com.javastudio.tutorial.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(generator = "SEQ_GEN", strategy = GenerationType.SEQUENCE)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
