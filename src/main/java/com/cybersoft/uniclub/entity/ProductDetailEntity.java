package com.cybersoft.uniclub.entity;

import com.cybersoft.uniclub.entity.key.ProductDetailID;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "productdetail")
@Setter
@Getter
public class ProductDetailEntity {

    @EmbeddedId
    private ProductDetailID id;

    @Column(name = "Soluong")
    private int soLuong;


}
