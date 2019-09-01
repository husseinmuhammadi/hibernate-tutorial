package com.javastudio.tutorial.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionProvider {

    static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration cfg = new Configuration()
//                    .addAnnotatedClass(AppletInfo.class)
                    .configure("hibernate.cfg.xml");
            SESSION_FACTORY = cfg.buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() throws HibernateException {
        return SESSION_FACTORY.openSession();
    }

}
