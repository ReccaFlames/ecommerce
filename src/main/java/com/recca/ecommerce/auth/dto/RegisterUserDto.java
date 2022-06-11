package com.recca.ecommerce.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
}
