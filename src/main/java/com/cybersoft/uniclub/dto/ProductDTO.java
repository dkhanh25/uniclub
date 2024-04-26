package com.cybersoft.uniclub.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private int idSanPham;
    private String productName;
    private double price;
    private String image;
}
