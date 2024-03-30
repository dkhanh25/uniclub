package com.cybersoft.uniclub.service;

import com.cybersoft.uniclub.entity.ProductEntity;
import com.cybersoft.uniclub.payload.request.InsertProductRequest;
import com.cybersoft.uniclub.repository.ProductRepository;
import com.cybersoft.uniclub.service.imp.FileServiceImp;
import com.cybersoft.uniclub.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private FileServiceImp fileServiceImp;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean insertProduct(InsertProductRequest productRequest) {
        fileServiceImp.saveFile(productRequest.getFile());

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setPrice(productRequest.getPrice());
        productEntity.setImage(productRequest.getFile().getOriginalFilename());

        productRepository.save(productEntity);


        return false;
    }
}
