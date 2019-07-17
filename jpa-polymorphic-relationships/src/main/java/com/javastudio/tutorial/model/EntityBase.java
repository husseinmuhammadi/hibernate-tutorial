package com.javastudio.tutorial.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class EntityBase {

    @Id
    @GeneratedValue(generator = "SEQ_GEN", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @Embedded
    private Audit audit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}
