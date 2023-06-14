package org.dummyapi.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;


import java.util.List;
import java.util.Map;
import io.restassured.config.SSLConfig;

import static org.dummyapi.configuration.DummyApiProperties.*;

public class RequestConfiguration {

    public static RequestSpecification get() {
        RequestSpecBuilder requestCfg = new RequestSpecBuilder();
        if (API_LOGLEVEL.getValue().equals("ALL")){
            requestCfg.log(LogDetail.ALL).addFilters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()));
        }
        return requestCfg
                .setBaseUri(API_BASE_URL
                        .getValue())
                        .addHeaders(Map.of("app-id", API_KEY.getValue()))
                        .addHeader("accept","application/json")
                        .addHeader("Content-Type", "application/json")
                        .setBasePath("").build();
    }
}
