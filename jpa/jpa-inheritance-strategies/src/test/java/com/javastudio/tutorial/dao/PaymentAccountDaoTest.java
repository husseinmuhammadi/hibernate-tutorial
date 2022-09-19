package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.PaymentAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentAccountDaoTest {

    @Spy
    PaymentAccountDao paymentAccountDao;

    @Test
    void savePaymentAccount() {
        paymentAccountDao.getEntityManager().getTransaction().begin();
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setAccountNumber(UUID.randomUUID().toString());
        paymentAccountDao.save(paymentAccount);
        paymentAccountDao.getEntityManager().getTransaction().commit();
    }
}