package com.javastudio.tutorial.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("C")
public class Company implements VehicleOwner {

    public Company() {
    }

    public Company(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue
    long id;

    String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
