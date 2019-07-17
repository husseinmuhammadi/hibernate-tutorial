package com.javastudio.tutorial;

import com.javastudio.tutorial.model.*;
import com.javastudio.tutorial.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Startup {
    static Logger logger = LoggerFactory.getLogger(Startup.class);

    static ProductService productService = new ProductService();
    static VehicleService vehicleService = new VehicleService();
    static PersonService personService = new PersonService();
    static CompanyService companyService = new CompanyService();
    static TaskService taskService = new TaskService();
    static IssueService issueService = new IssueService();
    static EntityHistoryService entityHistoryService = new EntityHistoryService();

    public static void main(String[] args) {
        logger.info("Start ...");

//        saveProducts();
//        saveVehicle();
//        findVehicles();

        saveIssue();
        saveTask();
        findAllEntityHistory();

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

    private static void saveProducts() {
        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.setTitle("Computer");
            productService.save(product);
        }
    }

    private static void saveIssue() {
        Issue issue = new Issue();
        issue.setTitle("#14566");
        issue.setStatus("E");
        issueService.save(issue);

        EntityHistory entityHistory = new EntityHistory();
        entityHistory.setEntity(issue);
        entityHistory.setAction("Create new entity");
        entityHistory.setUsername("h.mohammadi");
        entityHistoryService.save(entityHistory);
    }

    private static void saveTask() {
        Task task = new Task();
        task.setTitle("Create a new module SSM");
        task.setStatus("E");
        taskService.save(task);

        EntityHistory entityHistory = new EntityHistory();
        entityHistory.setEntity(task);
        entityHistory.setAction("Create new task");
        entityHistory.setUsername("h.mohammadi");
        entityHistoryService.save(entityHistory);
    }

    private static void findAllEntityHistory() {
        List<EntityHistory> entityHistories = entityHistoryService.findAllEntityHistory();
        for (EntityHistory history : entityHistories) {
            EntityBase entity = (EntityBase) history.getEntity();
            System.out.println(
                    String.format("%s %d %s by %s",
                            entity.getClass().getSimpleName(), entity.getId(), history.getAction(), history.getUsername()
                    )
            );
        }
    }


}
