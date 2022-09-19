package com.javastudio.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = {
            CascadeType.PERSIST, CascadeType.REMOVE
    })
    private List<Account> accounts;
}
