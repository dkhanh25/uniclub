package com.cybersoft.uniclub.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest {

    @Getter
    @Setter
    @NotBlank(message = "Username khong duoc phep rong")
    private String username;

    @Getter
    @Setter
    @NotBlank(message = "Vui long nhap password")
    private String password;

}
