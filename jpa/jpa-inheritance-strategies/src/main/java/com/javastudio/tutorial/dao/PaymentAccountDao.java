package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.PaymentAccount;

import java.util.List;

public class PaymentAccountDao extends GenericDao<PaymentAccount> {
    public PaymentAccountDao() {
        super(EntityManagerProvider.PRIMARY_PERSISTENCE_UNIT, PaymentAccount.class);
    }

    @Override
    protected List<PaymentAccount> findAll() {
        return null;
    }
}
