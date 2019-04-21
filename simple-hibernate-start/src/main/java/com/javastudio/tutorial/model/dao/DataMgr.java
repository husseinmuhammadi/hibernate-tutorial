package com.javastudio.tutorial.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;


public class DataMgr {
    static Logger logger = LoggerFactory.getLogger(DataMgr.class);

    private static Configuration configuration;
    private static SessionFactory factory;

    static {
        try {
            configuration = new Configuration().configure("hibernate.cfg.xml");
            factory = configuration.buildSessionFactory();
        } catch (Throwable e) {
            logger.error("Error initializing hibernate", e);
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static void printTables() /*throws MappingException*/ {
        Iterator classMappings = configuration.getClassMappings();

        while (classMappings.hasNext()) {
            PersistentClass persistentClass = (PersistentClass) classMappings.next();

            Table table = persistentClass.getTable();
            String tableName = table.getName();

            Iterator columnIterator = table.getColumnIterator();

            while (columnIterator.hasNext()) {
                Column column = (Column) columnIterator.next();
                String columnName = column.getName();

                logger.info(tableName + "." + columnName);
            }
        }
    }
}
