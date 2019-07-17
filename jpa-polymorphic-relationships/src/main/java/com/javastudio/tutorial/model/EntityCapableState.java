package com.javastudio.tutorial.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "SEQ_GEN", sequenceName = "Entity_Capable_State_SEQ")
@Table(name = "Entity_Capable_State")
@NamedQueries({
        @NamedQuery(name = EntityCapableState.FIND_BY_ENTITY_TYPE, query = "select t from EntityCapableState t where t.entityMetaValue = :entityMetaValue")
})
public class EntityCapableState extends EntityBase {

    public static final String FIND_BY_ENTITY_TYPE = "EntityCapableState.findByEntityType";

    String entityMetaValue;

    String currentState;

    String nextState;

    String requiredPermission;

    public String getEntityMetaValue() {
        return entityMetaValue;
    }

    public void setEntityMetaValue(String entityMetaValue) {
        this.entityMetaValue = entityMetaValue;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getNextState() {
        return nextState;
    }

    public void setNextState(String nextState) {
        this.nextState = nextState;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(String requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}
