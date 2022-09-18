package com.javastudio.tutorial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public enum EntityManagerProvider {
    PRIMARY_PERSISTENCE_UNIT("primary-persistence-unit");

    private final EntityManagerFactory entityManagerFactory;

    EntityManagerProvider(String persistenceUnitName) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
    }

    public synchronized EntityManager getEntityManager() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.setFlushMode(FlushModeType.COMMIT);
        return entityManager;
    }
}
