package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.PersonDA;
import com.javastudio.tutorial.model.Person;

import java.util.List;

public class PersonService {

    private static final PersonService personService = new PersonService();

    private PersonService() {

    }

    public static PersonService getInstance() {
        return personService;
    }

    public void save(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    public List<Person> getAll() throws Exception {
        PersonDA personDA = new PersonDA();
        List<Person> people = personDA.select();
        personDA.close();
        return people;
    }
}
