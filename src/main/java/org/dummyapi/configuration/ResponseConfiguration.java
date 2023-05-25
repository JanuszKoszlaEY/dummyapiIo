package org.dummyapi.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class ResponseConfiguration {
    private final static long TIME_OUT = 5000;
    public static ResponseSpecification get() {
        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectResponseTime(Matchers.lessThanOrEqualTo(TIME_OUT));
        return responseBuilder.build();
    }
}
