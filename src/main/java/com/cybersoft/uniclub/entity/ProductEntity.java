package com.cybersoft.uniclub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name="product")
public class ProductEntity {
    @Id
    @Column(name = "ID_product")
    @Getter
    @Setter
    private int idProduct;

    @Column(name = "product_name")
    @Getter
    @Setter
    private String productName;

    @Column(name = "price")
    @Getter
    @Setter
    private double price;

    @Column(name = "images")
    @Getter
    @Setter
    private String image;

}
