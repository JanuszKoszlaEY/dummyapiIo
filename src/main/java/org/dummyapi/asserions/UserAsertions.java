package org.dummyapi.asserions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.requests.UserRequests;
import org.testng.Assert;

public class UserAsertions {
    public static ValidatableResponse assertThatResponseCodeIs(Response response, int expectedValue){
        return response.then().statusCode(expectedValue);
    }
    public static ValidatableResponse assertThatUserIsCreated(String id){
        UserRequests userRequests = new UserRequests();
        Response response = userRequests.getUserById(id);
        return assertThatResponseCodeIs(response, 200);


    }
}
