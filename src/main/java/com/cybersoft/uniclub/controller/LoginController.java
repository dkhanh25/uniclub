package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.payload.request.LoginRequest;
import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.cybersoft.uniclub.service.imp.LoginServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping("")
    public ResponseEntity<?> login(@Valid LoginRequest loginRequest){
        String token = loginServiceImp.checkLogin(loginRequest.getUsername(), loginRequest.getPassword());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(!token.trim().isEmpty() ? 200 : 401);
        baseResponse.setData(token);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
