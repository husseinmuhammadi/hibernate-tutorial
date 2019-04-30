package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.EntityManagerProvider;
import com.javastudio.tutorial.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public void save(Product product) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } catch (Throwable e) {
            logger.error("Error while saving product", e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            em.close();
        }
    }
}
