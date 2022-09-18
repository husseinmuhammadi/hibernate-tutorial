package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDao extends GenericDao<Product> implements TransactionSupport {

    public ProductDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, Product.class);
    }

    @Override
    protected List<Product> findAll() {
        return getEntityManager().createQuery("select t from Product t", Product.class).getResultList();
    }
}
