package com.javastudio.tutorial.model.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityBase {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    private long id;

    @Version
    Long version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
