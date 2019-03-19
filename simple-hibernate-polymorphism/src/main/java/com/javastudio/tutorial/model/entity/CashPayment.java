package com.javastudio.tutorial.model.entity;

public class CashPayment extends PaymentBase implements Payment {

    String payerName;

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }
}
