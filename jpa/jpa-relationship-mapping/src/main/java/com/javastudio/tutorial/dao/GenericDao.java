package com.javastudio.tutorial.dao;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDao<T> {
    private final EntityManager entityManager;
    private final Class<T> entityType;

    public GenericDao(EntityManagerProvider emp, Class<T> entityType) {
        this.entityManager = emp.getEntityManager();
        this.entityType = entityType;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T findById(Long id) {
        return entityManager.find(entityType, id);
    }

    protected abstract List<T> findAll();

    public void begin() {
        entityManager.getTransaction().begin();
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }

    public void rollback() {
        entityManager.getTransaction().rollback();
    }
}
