package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.cybersoft.uniclub.service.imp.LoginServiceImp;
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
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){

        String token = loginServiceImp.checkLogin(username,password);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(token);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
