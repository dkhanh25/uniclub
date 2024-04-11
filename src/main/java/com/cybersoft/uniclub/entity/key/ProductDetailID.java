package com.cybersoft.uniclub.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProductDetailID implements Serializable {

    @Column(name = "ID_product")
    private int idProduct;

    @Column(name = "ID_tag")
    private int idTag;

    @Column(name = "ID_category")
    private int idCategory;

    @Column(name = "ID_color")
    private int idColor;

    @Column(name = "ID_size")
    private int idSize;

    public ProductDetailID(int idProduct, int idCategory, int idColor, int idSize, int idTag) {
        this.idProduct = idProduct;
        this.idCategory = idCategory;
        this.idSize = idSize;
        this.idColor = idColor;
        this.idTag = idTag;
    }


    public ProductDetailID() {
    }
}
