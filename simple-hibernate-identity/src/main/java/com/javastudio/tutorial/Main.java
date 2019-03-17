package com.javastudio.tutorial;

import com.javastudio.tutorial.model.entity.Opportunity;
import com.javastudio.tutorial.model.entity.Person;
import com.javastudio.tutorial.model.entity.Role;
import com.javastudio.tutorial.service.OpportunityService;
import com.javastudio.tutorial.service.PersonService;
import com.javastudio.tutorial.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        Person person = new Person();
        person.setName("Ali");
        PersonService personService = new PersonService();
        personService.save(person);
        logger.info("Person saved successfully");

        Role role = new Role();
        role.setName("admin");
        RoleService roleService = new RoleService();
        roleService.save(role);
        logger.info("Role saved successfully");

        for (int i = 0; i < 100; i++) {
            Opportunity opportunity = new Opportunity();
            opportunity.setOpportunityName("Manager");
            OpportunityService opportunityService = new OpportunityService();
            opportunityService.save(opportunity);
            logger.info("Opportunity saved successfully");
        }
    }
}
