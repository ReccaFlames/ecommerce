package com.recca.ecommerce.auth;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import com.recca.ecommerce.auth.dto.LoginUserDto;
import com.recca.ecommerce.auth.dto.RegisterUserDto;
import com.recca.ecommerce.config.KeycloakProvider;
import com.recca.ecommerce.keycloak.KeycloakAdminClientService;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final KeycloakAdminClientService kClientService;
    private final KeycloakProvider kcProvider;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserDto registerUserDto) {
        Response createdResponse = kClientService.createKeycloakUser(registerUserDto);
        return ResponseEntity.status(createdResponse.getStatus()).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResponse> login(@RequestBody LoginUserDto loginUserDto) {
        Keycloak keycloak = kcProvider.newKeycloakBuilderWithPasswordCredentials(loginUserDto.getUsername(), loginUserDto.getPassword()).build();
        try {
            AccessTokenResponse accessTokenResponse = keycloak.tokenManager().getAccessToken();
            return ResponseEntity.ok(accessTokenResponse);
        } catch (BadRequestException ex) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
