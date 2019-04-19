package com.javastudio.tutorial.model.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
    static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("primary");
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
