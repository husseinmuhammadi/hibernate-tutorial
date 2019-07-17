package com.javastudio.tutorial;

import com.google.common.reflect.ClassPath;
import com.javastudio.tutorial.model.*;
import com.javastudio.tutorial.service.*;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.AnyMetaDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Startup {
    static Logger logger = LoggerFactory.getLogger(Startup.class);

    static ProductService productService = new ProductService();
    static VehicleService vehicleService = new VehicleService();
    static PersonService personService = new PersonService();
    static CompanyService companyService = new CompanyService();
    static TaskService taskService = new TaskService();
    static IssueService issueService = new IssueService();
    static EntityHistoryService entityHistoryService = new EntityHistoryService();
    static EntityCapableStateService entityCapableStateService = new EntityCapableStateService();

    public static void main(String[] args) {
        logger.info("Start ...");

//        saveProducts();
//        saveVehicle();
//        findVehicles();

//        saveIssue();
//        saveTask();
//        findAllEntityHistory();
//
//        findEntityCapableState();

        try {
            ClassPath classPath = ClassPath.from(Issue.class.getClassLoader());
            AnyMetaDefs anyMetaDefs = classPath.getTopLevelClassesRecursive("com.javastudio.tutorial.model")
                    .stream().filter(c -> c.getSimpleName().equals("package-info"))
                    .map(c -> c.load().getPackage().getAnnotation(AnyMetaDefs.class))
                    .collect(toSingleton());
                    // .forEach(a -> System.out.println(a.toString()));
            AnyMetaDef[] c = anyMetaDefs.value();
        } catch (IOException e) {
            e.printStackTrace();
        }



        logger.info("End ...");
    }

    public static <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        );
    }










    private static void findEntityCapableState() {

        List<EntityCapableState> entityCapableStates = entityCapableStateService.findEntityCapableStates(Issue.class);

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

        saveHistory(issue, "has been created");
    }

    private static void saveHistory(Auditable auditable, String action) {
        EntityHistory entityHistory = new EntityHistory();
        entityHistory.setEntity(auditable);
        entityHistory.setStatus(auditable.getStatus());
        entityHistory.setAudit(auditable.getAudit());
        entityHistory.setAction(action);
        entityHistoryService.save(entityHistory);
    }

    private static void saveTask() {
        Task task = new Task();
        task.setTitle("Create a new module SSM");
        task.setStatus("E");
        taskService.save(task);

        saveHistory(task, "has been created");
    }

    private static void findAllEntityHistory() {
        List<EntityHistory> entityHistories = entityHistoryService.findAllEntityHistory();
        for (EntityHistory history : entityHistories) {
            EntityBase entity = (EntityBase) history.getEntity();
            System.out.println(
                    String.format("%s %d with status %s %s by %s",
                            entity.getClass().getSimpleName(), entity.getId(), history.getStatus(), history.getAction(), history.getAudit().getCreatedBy()
                    )
            );
        }
    }


}
