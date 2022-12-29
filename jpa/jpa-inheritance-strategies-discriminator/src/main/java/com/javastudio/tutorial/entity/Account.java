package com.javastudio.tutorial.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String accountNumber;

    @ManyToOne
    private Customer customer;
}
