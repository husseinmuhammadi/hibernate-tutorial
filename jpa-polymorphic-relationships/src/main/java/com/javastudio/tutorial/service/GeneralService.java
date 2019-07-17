package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public abstract class GeneralService {

    Logger logger = LoggerFactory.getLogger(GeneralService.class);

    public Object save(Object o) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(o);
            transaction.commit();
            return o;
        } catch (Throwable e) {
            logger.error("Error while saving product", e);
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
