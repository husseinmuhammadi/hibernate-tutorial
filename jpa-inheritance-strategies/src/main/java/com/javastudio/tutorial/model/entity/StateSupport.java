package com.javastudio.tutorial.model.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ENTITY_INDICATOR")
@Table(name = "ENTITY_BASE")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PERSON_SEQ")
public class StateSupport extends EntityBase {

    @Column(name = "STATE", length = 40)
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
