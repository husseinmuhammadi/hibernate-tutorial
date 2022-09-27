package com.javastudio.tutorial.model.entity;

public interface Payment {

    long getPaymentId() ;

    void setPaymentId(long paymentId) ;

    long getPaymentAmount() ;

    void setPaymentAmount(long paymentAmount) ;

    String getPaymentCurrency() ;

    void setPaymentCurrency(String paymentCurrency) ;
}
