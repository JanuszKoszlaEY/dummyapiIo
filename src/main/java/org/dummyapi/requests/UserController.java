package org.dummyapi.requests;

import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.UserDTO;
import org.dummyapi.endpoints.UserEndpoints;

import static io.restassured.RestAssured.given;


public class UserController {
    public Response createUser(UserDTO userDTO) {
        return given(RequestConfiguration.get().body(userDTO), ResponseConfiguration.get())
                .post(UserEndpoints.userCreate);
    }
}
