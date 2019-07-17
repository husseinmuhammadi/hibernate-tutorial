package com.javastudio.tutorial.model;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;


@javax.persistence.Entity
public class Vehicle {

    @Id
    @GeneratedValue
    long id;

    @Any(
            metaDef = "EntityMetaDef",
            metaColumn = @Column(name = "owner_type", length = 1),
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "owner_id")
    VehicleOwner owner;

    public VehicleOwner getOwner() {
        return owner;
    }

    public void setOwner(VehicleOwner owner) {
        this.owner = owner;
    }

    /*
    @ManyToAny(
            metaColumn = @Column( name = "owner_type" )
    )
    @AnyMetaDef(
            idType = "integer", metaType = "string",
            metaValues = {
                    @MetaValue( targetEntity = Person.class, value="PRS" ),
                    @MetaValue( targetEntity = Company.class, value="CPY" )
            }
    )
    @Cascade( { org.hibernate.annotations.CascadeType.ALL } )
    @JoinTable(
            name = "vehicle_owners",
            joinColumns = @JoinColumn( name = "vehicle_id" ),
            inverseJoinColumns = @JoinColumn( name = "owner_id" )
    )
    public List<Property> getOwners() { return  }
    private void setOwners(List<VehicleOwner> owners) { ... }
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
