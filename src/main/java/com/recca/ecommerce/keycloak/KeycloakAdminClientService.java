package com.recca.ecommerce.keycloak;

import java.util.Collections;

import com.recca.ecommerce.auth.dto.RegisterUserDto;
import com.recca.ecommerce.config.KeycloakProvider;

import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.ws.rs.core.Response;

@Service
public class KeycloakAdminClientService {

    @Value("${keycloak.realm}")
    public String realm;

    private final KeycloakProvider kcProvider;


    public KeycloakAdminClientService(KeycloakProvider keycloakProvider) {
        this.kcProvider = keycloakProvider;
    }

    public Response createKeycloakUser(RegisterUserDto user) {
        UsersResource usersResource = kcProvider.getInstance().realm(realm).users();
        CredentialRepresentation credentialRepresentation = createPasswordCredentials(user.getPassword());

        UserRepresentation kcUser = new UserRepresentation();
        kcUser.setUsername(user.getEmail());
        kcUser.setCredentials(Collections.singletonList(credentialRepresentation));
        kcUser.setFirstName(user.getFirstname());
        kcUser.setLastName(user.getLastname());
        kcUser.setEmail(user.getEmail());
        kcUser.setEnabled(true);
        kcUser.setEmailVerified(false);

        Response response = usersResource.create(kcUser);

        if (response.getStatus() == 201) {
            //If you want to save the user to your other database, do it here
        }

        return response;

    }

    private static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
    
}
