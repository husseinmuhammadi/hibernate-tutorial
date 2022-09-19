package com.javastudio.tutorial.entity;

import lombok.Builder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class PaymentAccount extends Account {
}
