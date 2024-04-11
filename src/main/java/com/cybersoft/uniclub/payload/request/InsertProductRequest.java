package com.cybersoft.uniclub.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class InsertProductRequest {

    @Setter
    private String productName;

    @Setter
    private int idTag;

    @Setter
    private int idCategory;

    @Setter
    private int idColor;

    @Setter
    private int idSize;

    @Setter
    private int soLuong;

    @Setter
    private double price;

    @Setter
    private MultipartFile file;


}
