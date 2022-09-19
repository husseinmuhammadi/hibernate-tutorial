package com.javastudio.tutorial;

import com.javastudio.tutorial.model.base.JPA;
import com.javastudio.tutorial.model.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class JSample {
    static Logger logger = LoggerFactory.getLogger(JSample.class);

    public void savePerson() {
        EntityManager entityManager = JPA.getEntityManager();
        try {
            Person person = new Person();
            person.setFirstName("Hossein");
            person.setLastName("Mohammadi");
            person.setBirthdate(new Date());

            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
            logger.info("Person saved successfully.");
        } catch (Throwable e) {
            logger.error("Error", e);
            entityManager.getTransaction().rollback();
        } finally {
            logger.info("Closing the connection.");
            entityManager.close();
        }
    }

    public void listPeople() {
        EntityManager em = JPA.getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Person> cq = cb.createQuery(Person.class);
            Root<Person> personRoot = cq.from(Person.class);
            cq.select(personRoot);
            TypedQuery<Person> q = em.createQuery(cq);
            List<Person> people = q.getResultList();
            for (Person person : people) {
                logger.info(person.getFirstName() + " " + person.getLastName());
            }
        } catch (Throwable e) {
            logger.error("Error", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
