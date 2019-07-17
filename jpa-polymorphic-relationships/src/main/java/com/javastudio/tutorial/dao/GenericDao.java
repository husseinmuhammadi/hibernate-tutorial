package com.javastudio.tutorial.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class GenericDao<T> {

    private final Class<T> entityBeanType;

    public GenericDao(Class<T> entityBeanType) {
        this.entityBeanType = entityBeanType;
    }

    Logger logger = LoggerFactory.getLogger(GenericDao.class);

    public TypedQuery<T> createNamedQuery(String namedQueryName, Map<String, Object> parameters) {
        return createNamedQuery(namedQueryName, parameters, 0);
    }

    public TypedQuery<T> createNamedQuery(String namedQueryName, Map<String, Object> parameters, int limitResult) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        TypedQuery typedQuery = createNamedQuery(namedQueryName);
        if (limitResult > 0) {
            typedQuery.setMaxResults(limitResult);
        }
        for (Map.Entry<String, Object> entry : rawParameters) {
            typedQuery.setParameter(entry.getKey(), entry.getValue());
        }
        return typedQuery;
    }

    public TypedQuery<T> createNamedQuery(String queryName) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            logger.debug(MessageFormat.format("Create named query: {0}", queryName));
            Arrays.stream(Thread.currentThread().getStackTrace()).forEach(i -> logger.debug(i.getClassName() + ":" + i.getMethodName()));
            return em.createNamedQuery(queryName, entityBeanType);
        } finally {
            em.close();
        }
    }
}
