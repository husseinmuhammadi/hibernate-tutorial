package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.HibernateSessionProvider;
import com.javastudio.tutorial.model.EntityBase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import java.util.List;

public class GeneralService<T extends EntityBase> {
    Logger logger = LoggerFactory.getLogger(GeneralService.class);

    public void save(T entity) {
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

    public List findAll(Class<T> tClass) {
        Session session = HibernateSessionProvider.getSession();
        try {
            Query query = session.createQuery("select o from " + tClass.getAnnotation(Entity.class).name() + " o");
            return query.list();
        } catch (Throwable e) {
            logger.error("Error saving transaction", e);
            return null;
        } finally {
            if (session.isOpen()) session.close();
        }
    }
}
