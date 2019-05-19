package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.exceptions.BusinessException;
import com.javastudio.tutorial.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDA extends GenericDA {

    public void insert(Person person) throws Exception {
        try (PreparedStatement preparedStatement = prepareStatement("insert into person(id, first_name, last_name) VALUES (?, ?, ?)")) {
            preparedStatement.setLong(1, person.getId());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }

    public List<Person> select() {
        try (PreparedStatement preparedStatement = prepareStatement("select * from person")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> people = new ArrayList<>();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
                people.add(person);
            }
            return people;
        } catch (SQLException e) {
            throw new BusinessException(e);
        }
    }
}
