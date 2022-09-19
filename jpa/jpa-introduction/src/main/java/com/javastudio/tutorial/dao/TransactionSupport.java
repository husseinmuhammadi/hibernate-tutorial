package com.javastudio.tutorial.dao;

public interface TransactionSupport {
    void begin();
    void commit();
    void rollback();
}
