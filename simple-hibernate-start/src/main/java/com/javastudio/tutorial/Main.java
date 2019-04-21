package com.javastudio.tutorial;

import com.javastudio.tutorial.model.dao.DataMgr;
import com.javastudio.tutorial.model.to.ProductSpecification;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Session session = DataMgr.getSession();
        try {
            DataMgr.printTables();

            session.beginTransaction();
            ProductSpecification productSpecification = new ProductSpecification();
            productSpecification.setKey("weigth");
            productSpecification.setValue("10");
            session.persist(productSpecification);
            session.getTransaction().commit();
            logger.info("product specification saved successfully");
        } catch (Throwable e) {
            logger.error("error ", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}
