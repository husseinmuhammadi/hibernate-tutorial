package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.repository.DataMgr;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class GenericService<T> {

    Logger logger = LoggerFactory.getLogger(GenericService.class);

    final Class<T> tClass;

    protected GenericService(Class<T> tClass) {
        this.tClass = tClass;
    }

    public void save(T t) {
        Session session = null;
        try {
            session = DataMgr.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Throwable e) {
            logger.error("Error while saving object", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    public List list() {
        Session session = null;
        try {
            session = DataMgr.openSession();
            return session.createCriteria(tClass).list();
        } catch (Throwable e) {
            logger.error("Error while getting list of objects", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return null;
    }
}
