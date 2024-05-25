package com.cybersoft.uniclub.dto;

import lombok.Getter;
import lombok.Setter;

@getter;
@setter;
public class ProductDTO implements Serializable {
    private int idSanPham;
    private String productName;
    private double price;
    private String image;

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public string getProductName() {
        return productName;
    }

    public void setProductName(string productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public string getImage() {
        return image;
    }

    public void setImage(string image) {
        this.image = image;
    }
    
}
