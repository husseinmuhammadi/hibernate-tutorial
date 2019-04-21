package com.javastudio.tutorial.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;


public class DataMgr {
    static Logger logger = LoggerFactory.getLogger(DataMgr.class);

    private static Configuration configuration;
    private static SessionFactory factory;

    static {
        try {
            // A SessionFactory is set up once for an application!
            configuration = new Configuration().configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
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
