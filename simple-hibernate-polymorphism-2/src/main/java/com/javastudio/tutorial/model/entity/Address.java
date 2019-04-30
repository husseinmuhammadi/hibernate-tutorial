package com.javastudio.tutorial.model.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "ADDRESS_SEQ")
public class Address extends EntityBase implements Contact {

    private String contactType;

    private String contactValue;

    @Override
    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    @Override
    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }
}
