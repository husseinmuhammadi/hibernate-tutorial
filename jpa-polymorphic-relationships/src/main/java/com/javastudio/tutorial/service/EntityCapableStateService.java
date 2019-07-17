package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.EntityManagerProvider;
import com.javastudio.tutorial.model.EntityCapableState;
import com.javastudio.tutorial.model.EntityHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EntityCapableStateService extends GeneralService {

    Logger logger = LoggerFactory.getLogger(EntityCapableStateService.class);

    public List<EntityCapableState> findEntityCapableStates(Class<?> entityType) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            // TypedQuery<EntityCapableState> query = em.createNamedQuery(EntityCapableState.FIND_BY_ENTITY_TYPE, QueryParameterUtil.with("username", username).parameters());
            // return em.createNamedQuery("select t from EntityHistory t", EntityHistory.class).getResultList();
            return null;
        } catch (Throwable e) {
            logger.error("Error while saving product", e);
            throw e;
        } finally {
            em.close();
        }
    }

}
