package com.javastudio.tutorial;

import com.javastudio.tutorial.model.entity.CardPayment;
import com.javastudio.tutorial.model.entity.CashPayment;
import com.javastudio.tutorial.model.entity.Payment;
import com.javastudio.tutorial.model.repository.DataMgr;
import com.javastudio.tutorial.service.CardPaymentService;
import com.javastudio.tutorial.service.CashPaymentService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    static CashPaymentService cashPaymentService;
    static CardPaymentService cardPaymentService;

    static {
        cashPaymentService = new CashPaymentService();
        cardPaymentService = new CardPaymentService();
    }

    public static void main(String[] args) {

        CashPayment cashPayment = new CashPayment();
        cashPayment.setPayerName("Hossein Mohammadi");
        cashPayment.setPaymentAmount(1000L);
        cashPayment.setPaymentCurrency("IRR");

        CardPayment cardPayment = new CardPayment();
        cardPayment.setPayingAccountNumber("5859471010067944");
        cardPayment.setTransferringBankName("Deutsche Bank");
        cardPayment.setPaymentAmount(1000);
        cardPayment.setPaymentCurrency("IRR");

        cashPaymentService.save(cashPayment);
        cardPaymentService.save(cardPayment);

        cashPaymentService.list();
        cardPaymentService.list();

        logger.info("-----------------------------------------------------");
        Session session = null;
        try {
            session = DataMgr.openSession();
            List<Payment> list = session.createCriteria(Payment.class).list();

            logger.info(String.format("|%-15s|%-6s|%-15s|%-10s|", "Class", "ID", "Amount", "Currency"));
            for (Payment o : list) {
                logger.info(String.format("|%-15s|%6d|%15d|%10s|", o.getClass().getSimpleName(), o.getPaymentId(), o.getPaymentAmount(), o.getPaymentCurrency()));
            }
        } catch (Throwable e) {
            logger.error("Error while getting list of objects", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
