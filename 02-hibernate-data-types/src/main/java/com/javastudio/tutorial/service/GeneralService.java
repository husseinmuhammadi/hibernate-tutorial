package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.HibernateSessionProvider;
import com.javastudio.tutorial.model.EntityBase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralService {
    Logger logger = LoggerFactory.getLogger(GeneralService.class);

    public void save(EntityBase entity) {
        Transaction tx = null;

        Session session = HibernateSessionProvider.getSession();
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(entity);
            tx.commit();
        } catch (Throwable e) {
            logger.error("Error saving transaction", e);
            if (tx != null) tx.rollback();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

}
