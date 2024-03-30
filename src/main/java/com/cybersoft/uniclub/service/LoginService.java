package com.cybersoft.uniclub.service;

import com.cybersoft.uniclub.entity.UsersEntity;
import com.cybersoft.uniclub.payload.response.RoleResponse;
import com.cybersoft.uniclub.repository.UsersRepository;
import com.cybersoft.uniclub.service.imp.LoginServiceImp;
import com.cybersoft.uniclub.utils.JwtUltils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUltils jwtUltils;

    private Gson gson = new Gson();

    @Override
    public String checkLogin(String username, String password) {
        String token = "";
        UsersEntity usersEntity = usersRepository.findByEmail(username);
        if(passwordEncoder.matches(password, usersEntity.getPassword()) ){
            //Tạo token từ key đã sinh ra và lưu trữ trước đó
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setName(usersEntity.getRole().getName());

            String roles = gson.toJson(roleResponse);
            token = jwtUltils.createToken(roles);
        }

        return token;
    }
}
