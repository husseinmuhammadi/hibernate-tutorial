package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.PaymentAccount;
import com.javastudio.tutorial.entity.SavingAccount;

import java.util.List;

public class SavingAccountDao extends GenericDao<SavingAccount> {
    public SavingAccountDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, SavingAccount.class);
    }

    @Override
    protected List<SavingAccount> findAll() {
        return null;
    }
}
