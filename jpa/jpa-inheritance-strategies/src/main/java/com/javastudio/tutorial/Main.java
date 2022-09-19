package com.javastudio.tutorial;

import com.javastudio.tutorial.model.base.JPA;
import com.javastudio.tutorial.model.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Date;

public class Main {
    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        JSample jSample = new JSample();
        jSample.savePerson();
        jSample.listPeople();



    }
}
