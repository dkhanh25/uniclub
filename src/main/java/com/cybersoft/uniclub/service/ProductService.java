package com.cybersoft.uniclub.service;

import com.cybersoft.uniclub.entity.ProductDetailEntity;
import com.cybersoft.uniclub.entity.ProductEntity;
import com.cybersoft.uniclub.entity.key.ProductDetailID;
import com.cybersoft.uniclub.exception.InsertException;
import com.cybersoft.uniclub.payload.request.InsertProductRequest;
import com.cybersoft.uniclub.repository.ProductDetailRepository;
import com.cybersoft.uniclub.repository.ProductRepository;
import com.cybersoft.uniclub.service.imp.FileServiceImp;
import com.cybersoft.uniclub.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private FileServiceImp fileServiceImp;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Transactional
    @Override
    public boolean insertProduct(InsertProductRequest productRequest) {
        boolean isSuccess = false;
        fileServiceImp.saveFile(productRequest.getFile());

        try {


            ProductEntity productEntity = new ProductEntity();
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setPrice(productRequest.getPrice());
            productEntity.setImage(productRequest.getFile().getOriginalFilename());

            productRepository.save(productEntity);

            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            ProductDetailID productDetailID = new ProductDetailID();
            productDetailID.setIdProduct(productEntity.getIdProduct());
            productDetailID.setIdCategory(productRequest.getIdCategory());
            productDetailID.setIdColor(productRequest.getIdColor());
            productDetailID.setIdTag(productRequest.getIdTag());
            productDetailID.setIdSize(productRequest.getIdSize());

            productDetailEntity.setId(productDetailID);
            productDetailEntity.setSoLuong(productRequest.getSoLuong());
            productDetailRepository.save(productDetailEntity);


            isSuccess = true;
        } catch (Exception e) {
            throw new InsertException("Loi them du lieu: " + e.getMessage());
        }

        return isSuccess;
    }
}
