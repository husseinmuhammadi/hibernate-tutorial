package com.javastudio.tutorial;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Startup {
    static Logger logger = LoggerFactory.getLogger(Startup.class);

    static ProductService productService = new ProductService();

    public static void main(String[] args) {
        logger.info("Start ...");

        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.setTitle("Computer");
            productService.save(product);
        }

        logger.info("End ...");
    }
}
