package com.javastudio.tutorial.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_GENERATOR")
    @Column(name = "ID")
    long id;
}
