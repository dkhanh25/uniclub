package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.payload.request.InsertProductRequest;
import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.cybersoft.uniclub.service.imp.ProductServiceImp;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final Gson gson = new Gson();

    @PostMapping
    public ResponseEntity<?> insertProduct(InsertProductRequest productRequest) {
         String jsonRequest = gson.toJson(productRequest);
         logger.info(jsonRequest);


        productServiceImp.insertProduct(productRequest);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("OK");

        logger.info(gson.toJson(baseResponse));

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<?> showProduct() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(productServiceImp.getAllProduct());
        return new  ResponseEntity<>(baseResponse,HttpStatus.OK);
    }
}
