package com.javastudio.tutorial.model.entity;

public class CardPayment extends PaymentBase implements Payment{

    String payingAccountNumber;

    String transferringBankName;

    public String getPayingAccountNumber() {
        return payingAccountNumber;
    }

    public void setPayingAccountNumber(String payingAccountNumber) {
        this.payingAccountNumber = payingAccountNumber;
    }

    public String getTransferringBankName() {
        return transferringBankName;
    }

    public void setTransferringBankName(String transferringBankName) {
        this.transferringBankName = transferringBankName;
    }

}
