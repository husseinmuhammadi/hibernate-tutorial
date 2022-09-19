package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.Customer;

import java.util.List;

public class CustomerDao extends GenericDao<Customer> {
    public CustomerDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, Customer.class);
    }

    @Override
    protected List<Customer> findAll() {
        return getEntityManager().createQuery("select c from Customer c", Customer.class).getResultList();
    }
}
