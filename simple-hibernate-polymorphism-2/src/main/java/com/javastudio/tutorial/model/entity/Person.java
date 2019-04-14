package com.javastudio.tutorial.model.entity;

import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@Table(name = "PERSON1")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PERSON_SEQ")
public class Person extends EntityBase {

    @Any(
            metaDef = "ContactMetaDef",
            metaColumn = @Column(name = "contact_type")
    )
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
