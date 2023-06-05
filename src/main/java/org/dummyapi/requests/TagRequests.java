package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.dummyapi.configuration.RequestConfiguration;
import org.dummyapi.configuration.ResponseConfiguration;
import org.dummyapi.endpoints.TagEndpoints;

public class TagRequests {
    public static Response tag() {
        return RestAssured.given(RequestConfiguration.get(), ResponseConfiguration.get())
                .get(TagEndpoints.tag);
    }
}
