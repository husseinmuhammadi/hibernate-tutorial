package com.javastudio.tutorial.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "PERSON")
@DiscriminatorValue("P")
@NamedQueries({
@NamedQuery(name = Person.FIND_ALL, query = "from Person")
})
public class Person extends StateSupport {

    public static final String FIND_ALL = "Persin.findAll";

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Temporal(TemporalType.DATE)
    Date birthdate;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
