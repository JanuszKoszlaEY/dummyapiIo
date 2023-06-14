package org.dummyapi.requests;

import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.endpoints.UserEndpoints;

import static io.restassured.RestAssured.given;


public class UserRequests {
    public static Response createUser(UserDto userDto) {
        return given(RequestConfiguration.get().body(userDto), ResponseConfiguration.get())
                .post(UserEndpoints.userCreate);
    }

    public static Response getUserById(String userId) {
        return given(RequestConfiguration.get().pathParam("id", userId), ResponseConfiguration.get())
                .get(UserEndpoints.userByID);
    }

    public static Response getUserList() {
        return given(RequestConfiguration.get(), ResponseConfiguration.get())
                .get(UserEndpoints.user);
    }

    public static Response updateUser(String userId, UserDto userDTO) {
        return given(RequestConfiguration.get().pathParam("id", userId).body(userDTO), ResponseConfiguration.get())
                .put(UserEndpoints.userByID);
    }

    public static Response deleteUser(String userId) {
        return given(RequestConfiguration.get().pathParam("id", userId), ResponseConfiguration.get())
                .delete(UserEndpoints.userByID);
    }
}
