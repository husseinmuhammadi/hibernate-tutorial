package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.repository.DataMgr;
import org.hibernate.Session;

public abstract class GenericService<T> {
    public void save(T t) {
        Session session = null;
        try {
            session = DataMgr.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
