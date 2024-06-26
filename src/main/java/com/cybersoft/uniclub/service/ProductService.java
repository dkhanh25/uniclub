package com.cybersoft.uniclub.service;

import com.cybersoft.uniclub.dto.ProductDTO;
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

import java.util.ArrayList;
import java.util.List;

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

            ProductEntity productFind = productRepository.findByProductName(productEntity.getProductName());
            ProductDetailEntity productDetailEntity = new ProductDetailEntity();
            ProductDetailID productDetailID = new ProductDetailID();
            System.out.println("Kiem tra: " + productFind.getIdProduct());
            productDetailID.setIdProduct(productFind.getIdProduct());
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

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        productEntities.forEach(item -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setIdSanPham(item.getIdProduct());
            productDTO.setProductName(item.getProductName());
            productDTO.setPrice(item.getPrice());
            productDTO.setImage("http://localhost:8080/file/" + item.getImage());
            productDTOS.add(productDTO);
        });

        return productDTOS;
    }


}
