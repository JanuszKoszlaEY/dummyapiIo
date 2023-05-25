package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {
    public static Response sendGetRequest(String url) {
        return RestAssured.get(url);
    }

    public static Response sendPostRequest(String url, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        return requestSpecification.post(url);
    }

    public static Response sendPutRequest(String url, String requestBody) {
        RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
        return requestSpecification.put(url);
    }

    public static Response sendDeleteRequest(String url) {
        return RestAssured.delete(url);
    }
}