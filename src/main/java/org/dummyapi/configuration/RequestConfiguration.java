package org.dummyapi.configuration;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SessionConfig;

import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

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
        RestAssured.baseURI = "http://dummyapi.io";
        this.config = RestAssured.config()
                .sessionConfig(new SessionConfig().sessionIdName("sessionId"));
    }

    public Response get(String body) {
        return RestAssured.with().config(this.config).body(body).get();
    }
}
