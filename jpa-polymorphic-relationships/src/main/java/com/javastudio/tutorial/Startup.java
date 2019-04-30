package com.javastudio.tutorial;

import com.javastudio.tutorial.model.*;
import com.javastudio.tutorial.service.CompanyService;
import com.javastudio.tutorial.service.PersonService;
import com.javastudio.tutorial.service.ProductService;
import com.javastudio.tutorial.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Startup {
    static Logger logger = LoggerFactory.getLogger(Startup.class);

    static ProductService productService = new ProductService();
    static VehicleService vehicleService = new VehicleService();
    static PersonService personService = new PersonService();
    static CompanyService companyService = new CompanyService();

    public static void main(String[] args) {
        logger.info("Start ...");

        savePersons();
        saveVehicle();
        findVehicles();

        logger.info("End ...");
    }

    private static void findVehicles() {
        List<Vehicle> vehicles = vehicleService.findVehicles();
        for (Vehicle vehicle : vehicles) {
            VehicleOwner owner = vehicle.getOwner();
            if (owner instanceof Person)
                logger.info(String.format("%s %s %s", owner.getClass().getSimpleName(), ((Person) owner).getFirstName(), ((Person) owner).getLastName()));
            else if (owner instanceof Company)
                logger.info(String.format("%s %s", owner.getClass().getSimpleName(), ((Company) owner).getTitle()));
        }
    }

    private static void saveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwner((VehicleOwner) personService.save(new Person("Hossein", "Mohammadi")));
        vehicleService.save(vehicle);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setOwner((VehicleOwner) companyService.save(new Company("Middle East Bank")));
        vehicleService.save(vehicle1);
    }

    private static void savePersons() {
        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.setTitle("Computer");
            productService.save(product);
        }
    }
}
