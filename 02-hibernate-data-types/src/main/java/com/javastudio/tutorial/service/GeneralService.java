package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.HibernateSessionProvider;
import com.javastudio.tutorial.model.EntityBase;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GeneralService {

    public void save(EntityBase entity) {
        Transaction tx = null;

        Session session = HibernateSessionProvider.getSession();
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(entity);
            tx.commit();
        } catch (Throwable e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session.isOpen()) session.close();
        }
    }

}
