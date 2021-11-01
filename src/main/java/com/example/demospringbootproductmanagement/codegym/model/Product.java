package com.example.demospringbootproductmanagement.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int quantity;

    private String image;

    private String manufacturer;

    @ManyToOne
    private Category category;
}
