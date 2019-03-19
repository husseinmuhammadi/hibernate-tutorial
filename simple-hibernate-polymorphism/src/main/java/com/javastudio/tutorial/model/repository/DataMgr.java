package com.javastudio.tutorial.model.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataMgr {

    final static SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession(){
        return SESSION_FACTORY.openSession();
    }






}
