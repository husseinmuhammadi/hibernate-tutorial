package com.javastudio.tutorial.model;

import org.hibernate.annotations.Any;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="SEQ_GEN", sequenceName = "EntityHistory_SEQ")
@Table(name = "ENTITY_HISTORY")
public class EntityHistory extends EntityBase {

    @Any(
            metaDef = "EntityMetaDef",
            metaColumn = @Column(name = "entity_name")
    )
    @JoinColumn(name = "ENTITY_ID")
    private Auditable entity;

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Auditable getEntity() {
        return entity;
    }

    public void setEntity(Auditable entity) {
        this.entity = entity;
    }
}
