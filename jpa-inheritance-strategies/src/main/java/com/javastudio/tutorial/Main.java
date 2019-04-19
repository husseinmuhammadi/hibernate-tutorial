package com.javastudio.tutorial;
import com.javastudio.tutorial.model.base.JPA;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPA.getEntityManager();

    }
}
