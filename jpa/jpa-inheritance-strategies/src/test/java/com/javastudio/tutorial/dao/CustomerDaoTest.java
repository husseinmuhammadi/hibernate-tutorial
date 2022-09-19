package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.Customer;
import com.javastudio.tutorial.entity.PaymentAccount;
import com.javastudio.tutorial.entity.SavingAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerDaoTest {

    @Spy
    CustomerDao customerDao;

    @Test
    void saveCustomer() {
        customerDao.begin();
        customerDao.save(Customer.builder()
                .name("Hossein")
                .build());
        customerDao.commit();
    }

    @Test
    void givenCascadePersist_whenSaveCustomerWithAccounts_thenItShouldSaveAccounts() {
        Customer customer = buildCustomerWithAccounts();

        customerDao.begin();
        customerDao.save(customer);
        customerDao.commit();
    }

    @Test
    void givenCascadeRemove_whenDeleteCustomer_thenItShouldRemoveTheAccounts() {
        Customer customer = buildCustomerWithAccounts();

        customerDao.begin();

        customerDao.save(customer);
        customerDao.getEntityManager().flush();

        List<Customer> customers = customerDao.findAll();

        customers.forEach(c -> {
            System.out.printf("Delete customer id:%d%n", c.getId());
            customerDao.getEntityManager().remove(c);
        });

        customerDao.commit();
    }

    @Test
    void empty(){

    }

    private Customer buildCustomerWithAccounts() {
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setAccountNumber(UUID.randomUUID().toString());
        SavingAccount savingAccount = new SavingAccount();
        savingAccount.setAccountNumber(UUID.randomUUID().toString());

        Customer customer = Customer.builder()
                .name("Hossein")
                .accounts(List.of(
                        paymentAccount, savingAccount
                )).build();

        customer.getAccounts().forEach(account -> account.setCustomer(customer));
        return customer;
    }

}