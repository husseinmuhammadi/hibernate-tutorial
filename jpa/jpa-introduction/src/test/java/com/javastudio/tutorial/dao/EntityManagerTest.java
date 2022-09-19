package com.javastudio.tutorial.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EntityManagerTest {
    private static EntityManagerFactory emf;

    @BeforeAll
    static void beforeAll() {
        emf = Persistence.createEntityManagerFactory("persistenceUnitName");
        assertNotNull(emf);
    }

    @Test
    void createEntityManager() {
        EntityManager em = emf.createEntityManager();
        assertNotNull(em);
    }
}
