package com.javastudio.tutorial.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataMgr {

    static Logger logger = LoggerFactory.getLogger(DataMgr.class);

    final static SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void save(final Object entity) {
        Session session = null;
        try {
            session = openSession();
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Throwable e) {
            logger.error("Error while saving entity");
            session.getTransaction().rollback();
            throw e;
        } finally {
            if (session != null)
                session.close();
        }
    }


}
