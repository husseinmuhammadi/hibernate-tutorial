package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.ProductDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {



    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void a(){
        Persistence.createEntityManagerFactory("persistenceUnitName");

//        ProductService productService = new ProductService(new ProductDao())
    }
}