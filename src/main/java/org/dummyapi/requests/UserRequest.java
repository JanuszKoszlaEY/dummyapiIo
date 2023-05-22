package org.dummyapi.requests;

import io.restassured.response.Response;
import org.dummyapi.configuration.RequestSpec;
import org.dummyapi.configuration.ResponseSpec;
import org.dummyapi.dataModels.endpoints.User;
import org.dummyapi.dataModels.requestBody.UserDto;

import static io.restassured.RestAssured.given;
public class UserRequest {
    public static Response createUser(UserDto body) {
        return given(RequestSpec.get().body(body), ResponseSpec.get())
                .post(User.userCreate);
    }

    public static Response updateUser(String id, UserDto body) {
        return given(RequestSpec.get().pathParam("id",id).body(body), ResponseSpec.get())
                .put(User.userById);
    }

    public static Response deleteUser(String id) {
        return given(RequestSpec.get().pathParam("id",id), ResponseSpec.get())
                .delete(User.userById);
    }

    public static Response getUserById(String id) {
        return given(RequestSpec.get().pathParam("id",id), ResponseSpec.get())
                .get(User.userById);
    }

    public static Response getUserList() {
        return given(RequestSpec.get(), ResponseSpec.get())
                .get(User.user);
    }

}
