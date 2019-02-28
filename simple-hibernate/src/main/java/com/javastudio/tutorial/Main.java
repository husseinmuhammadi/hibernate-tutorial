package com.javastudio.tutorial;

import model.SkilledUser;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import type.Skill;

import java.util.List;

public class Main {
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SESSION_FACTORY = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return SESSION_FACTORY.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        Transaction transaction = null;
        try {
            /*
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
            */


            System.out.println("Select from SkilledUser");
            Query query = session.createQuery("from SkilledUser ");
            List list = query.list();


            if (true) {
                System.out.println("Start saving a new skilled user");

                SkilledUser user = new SkilledUser();
                user.setName("Lowest Skilled user");
                user.setSkill(Skill.BEST);
                transaction = session.beginTransaction();
                session.save(user);
                transaction.commit();
            }


        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }
}
