package com.javastudio.tutorial;

import com.javastudio.tutorial.model.entity.Address;
import com.javastudio.tutorial.model.entity.Contact;
import com.javastudio.tutorial.model.entity.Person;
import com.javastudio.tutorial.model.entity.Telephone;
import com.javastudio.tutorial.model.repository.DataMgr;
import com.javastudio.tutorial.service.CardPaymentService;
import com.javastudio.tutorial.service.CashPaymentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HibernateSample {

    static Logger logger = LoggerFactory.getLogger(HibernateSample.class);

    static CashPaymentService cashPaymentService;
    static CardPaymentService cardPaymentService;

    static {
        cashPaymentService = new CashPaymentService();
        cardPaymentService = new CardPaymentService();
    }

    public void anySave() {
        logger.info("-----------------------------------------------------");
        Session session = null;
        try {
            session = DataMgr.openSession();
            // List<Person> list = session.createCriteria(Person.class).list();

            Address address = new Address();
            address.setContactType("addr");
            address.setContactValue("Tehran");

            Telephone telephone = new Telephone();
            telephone.setContactType("tel");
            telephone.setContactValue("9122113358");

            session.persist(address);
            session.persist(telephone);

            Person person = new Person();
            person.setContact(address);

            session.beginTransaction();
            session.persist(person);
            session.getTransaction().commit();

        } catch (Throwable e) {
            logger.error("Error while getting list of objects", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        logger.info("-----------------------------------------------------");
    }

    public void anyLoad() {
        logger.info("-----------------------------------------------------");
        Session session = null;
        try {
            session = DataMgr.openSession();
            List<Person> list = session.createCriteria(Person.class).list();

            for (Person person : list) {
                logger.info(person.getContact().getClass().getName());
                logger.info(person.getContact().getContactType());
                logger.info(person.getContact().getContactValue());
            }

        } catch (Throwable e) {
            logger.error("Error while getting list of objects", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        logger.info("-----------------------------------------------------");
    }
}

