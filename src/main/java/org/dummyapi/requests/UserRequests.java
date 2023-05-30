package org.dummyapi.requests;

import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.UserDTO;
import org.dummyapi.endpoints.UserEndpoints;

import static io.restassured.RestAssured.given;


public class UserRequests {
    public Response createUser(UserDTO userDTO) {
        return given(RequestConfiguration.get().body(userDTO), ResponseConfiguration.get())
                .post(UserEndpoints.userCreate);
    }

    public Response getUserById(String id) {
        return given(RequestConfiguration.get().pathParam("id", id), ResponseConfiguration.get())
                .post(UserEndpoints.userByID);
    }

    public Response getUserList() {
        return given(RequestConfiguration.get(), ResponseConfiguration.get())
                .post(UserEndpoints.user);
    }

    public Response updateUser(String id, UserDTO userDTO) {
        return given(RequestConfiguration.get().pathParam("id", id).body(userDTO), ResponseConfiguration.get())
                .put(UserEndpoints.userByID);
    }

    public Response deleteUser(String id) {
        return given(RequestConfiguration.get().pathParam("id", id), ResponseConfiguration.get())
                .delete(UserEndpoints.userByID);
    }
}
