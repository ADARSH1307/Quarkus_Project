package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product extends PanacheEntityBase {
    @Id
    public Long id;
    public String name;
    public double price;
}
