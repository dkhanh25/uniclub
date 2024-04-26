package com.cybersoft.uniclub.service.imp;

import com.cybersoft.uniclub.dto.ProductDTO;
import com.cybersoft.uniclub.payload.request.InsertProductRequest;

import java.util.List;

public interface ProductServiceImp {
    boolean insertProduct(InsertProductRequest productRequest);
    public List<ProductDTO> getAllProduct();
}
