package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.model.Product;
import jdk.jfr.Threshold;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class ProductDaoTest {

    @Spy
    ProductDao productDao;

    @Test
    void saveNewProduct() {
        ProductDao productDao = new ProductDao();

        productDao.getEntityManager().getTransaction().begin();

        Product computer = productDao.save(Product.builder()
                .title("Computer").build());

        System.out.println(computer.getId());

        productDao.getEntityManager().flush();

//        productDao.getEntityManager().getTransaction().commit();

    }

    @Test
    void saveProductAndRollback() throws InterruptedException {
        assertNotNull(productDao);

        productDao.begin();
        Product computer = productDao.save(Product.builder()
                .title("Computer").build());

        Long id = computer.getId();
        System.out.println(id);
        assertNotNull(id);

        productDao.rollback();

        Product product = productDao.findById(id);
        assertNull(product);
    }

    @Test
    void saveProductAndCommit() {
        assertNotNull(productDao);

        productDao.begin();
        Product computer = productDao.save(Product.builder()
                .title("Computer").build());

        Long id = computer.getId();
        System.out.println(id);
        assertNotNull(id);
        System.out.println(productDao.getEntityManager().getFlushMode());
//        productDao.getEntityManager().flush();
        productDao.commit();

        Product product = productDao.findById(id);
        assertNotNull(product);
    }


}