package com.javastudio.tutorial.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDA {

    private Logger logger = LoggerFactory.getLogger(GenericDA.class);

    private Connection connection;

    GenericDA() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@172.20.35.172:1521:dbebk", "Hossein", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Error initializing connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void close() throws SQLException {
        connection.close();
    }
}
