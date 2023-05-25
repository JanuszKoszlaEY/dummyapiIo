package org.dummyapi.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static org.dummyapi.configuration.DummyApiProperties.API_BASE_URL;

public class RequestConfiguration {

    private RestAssuredConfig config;

    private void setLogConfigToAllLogs() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    private void setLogConfigToRequestLogsOnly() {
        RestAssured.filters(new RequestLoggingFilter());
    }

    private void setLogConfigToNoLogs() {
        RestAssured.filters();
    }

    enum ReqLogLevel {NONE, ALL, REQ}

    public RequestConfiguration(ReqLogLevel logLevel) {
        switch (logLevel) {
            case ALL: {
                setLogConfigToAllLogs();
                break;
            }
            case NONE: {
                setLogConfigToNoLogs();
                break;
            }
            case REQ: {
                setLogConfigToRequestLogsOnly();
                break;
            }
        }
    }

    public static RequestSpecification get() {
        RequestSpecBuilder requestCfg = new RequestSpecBuilder();
        return requestCfg.setBaseUri(API_BASE_URL.getValue()).setBasePath("").build();
    }
}
