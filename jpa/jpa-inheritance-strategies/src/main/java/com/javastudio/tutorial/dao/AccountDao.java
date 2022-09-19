package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.Account;

import java.util.List;

public class AccountDao extends GenericDao<Account> {
    public AccountDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, Account.class);
    }

    @Override
    protected List<Account> findAll() {
        return getEntityManager().createQuery("select a from Account a", Account.class).getResultList();
    }
}
