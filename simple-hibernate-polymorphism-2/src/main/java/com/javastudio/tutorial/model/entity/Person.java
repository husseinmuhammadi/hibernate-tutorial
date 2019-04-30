package com.javastudio.tutorial.model.entity;

import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PERSON_SEQ")
public class Person extends EntityBase {

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String firstName;

    String lastName;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
