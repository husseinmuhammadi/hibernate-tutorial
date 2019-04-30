package com.javastudio.tutorial.service;

import com.javastudio.tutorial.dao.EntityManagerProvider;
import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class VehicleService extends GeneralService {

    Logger logger = LoggerFactory.getLogger(VehicleService.class);

    public List<Vehicle> findVehicles() {
        EntityManager em = EntityManagerProvider.getEntityManager();
        try {
            return em.createQuery("select t from Vehicle t", Vehicle.class).getResultList();
        } catch (Throwable e) {
            logger.error("Error while saving product", e);
            throw e;
        } finally {
            em.close();
        }
    }
}
