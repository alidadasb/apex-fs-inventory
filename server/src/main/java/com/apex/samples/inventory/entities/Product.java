package com.apex.samples.inventory.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    Integer id;

    @Column(unique=true)
    String name;
    double price;
    Integer quantity;
}
