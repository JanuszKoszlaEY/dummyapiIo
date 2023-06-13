package org.dummyapi.asserions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.dummyapi.requests.PostRequests;

public class PostAssertions {

    public static ValidatableResponse assertGivenResponseStatusCode(Response response, int expectedValue){

        return response.then().statusCode(expectedValue);
    }
}
