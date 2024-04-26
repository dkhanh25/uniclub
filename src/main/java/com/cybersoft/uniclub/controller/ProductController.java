package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.payload.request.InsertProductRequest;
import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.cybersoft.uniclub.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @PostMapping
    public ResponseEntity<?> insertProduct(InsertProductRequest productRequest) {

        productServiceImp.insertProduct(productRequest);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<?> showProduct() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getAllProduct());
        return new  ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
