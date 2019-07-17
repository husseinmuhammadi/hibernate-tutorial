package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.EntityManagerProvider;
import com.javastudio.tutorial.model.EntityHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class EntityHistoryService extends GeneralService {

    Logger logger = LoggerFactory.getLogger(EntityHistoryService.class);

    public List<EntityHistory> findAllEntityHistory() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            return em.createQuery("select t from EntityHistory t", EntityHistory.class).getResultList();
        } catch (Throwable e) {
            logger.error("Error while saving product", e);
            throw e;
        } finally {
            em.close();
        }
    }

}
