package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.PaymentAccount;
import com.javastudio.tutorial.entity.SavingAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountDaoTest {

    @Spy
    AccountDao accountDao;

    @Test
    void saveDifferentAccountTypes() {

        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setAccountNumber(UUID.randomUUID().toString());

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber(UUID.randomUUID().toString());

        accountDao.begin();
        accountDao.save(paymentAccount);
        accountDao.save(savingAccount);
        accountDao.commit();
    }

    @Test
    void findAllAccounts(){
        accountDao.findAll();
    }
}