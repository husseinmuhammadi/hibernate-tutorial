package com.javastudio.tutorial.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class PaymentAccount extends Account {
}
