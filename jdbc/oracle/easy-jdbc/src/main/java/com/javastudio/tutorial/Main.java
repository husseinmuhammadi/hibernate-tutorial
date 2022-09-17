package com.javastudio.tutorial;

import com.javastudio.tutorial.model.Person;
import com.javastudio.tutorial.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {

    static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Person person = new Person("Hossein", "Mohammadi");
            PersonService.getInstance().save(person);
            logger.info("Person saved successfully");

            List<Person> people = PersonService.getInstance().getAll();
            for (Person person1 : people) {
                logger.info(String.format("| %20s | %20s |", person1.getFirstName(), person1.getLastName()));
            }
        } catch (Throwable e) {
            logger.error("error", e);
        }
    }
}
