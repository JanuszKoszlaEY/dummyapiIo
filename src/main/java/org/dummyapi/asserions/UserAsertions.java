package org.dummyapi.asserions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.requests.UserRequests;

import static org.hamcrest.Matchers.equalTo;

public class UserAsertions {

    public static ValidatableResponse assertThatResponseCodeIs(Response response, int expectedValue){
        return response.then().statusCode(expectedValue);
    }
    public static ValidatableResponse assertThatUserIsCreated(String id){
        Response response = UserRequests.getUserById(id);
        return assertThatResponseCodeIs(response, 200);


    }

    public static ValidatableResponse assertThatUserGenderIsMale(String id) {
        Response response = UserRequests.getUserById(id);
        return response.then().body("gender", equalTo("male"));
    }
    public static ValidatableResponse assertThatUserIsDeleted(String id){
        Response response = UserRequests.getUserById(id);
        return assertThatResponseCodeIs(response, 404);
    }
}
