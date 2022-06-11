package com.recca.ecommerce.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginUserDto {
    
    private String username;
    private String password;
}
