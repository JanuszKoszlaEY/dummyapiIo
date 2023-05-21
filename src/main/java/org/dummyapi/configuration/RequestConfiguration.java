package org.dummyapi.configuration;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SessionConfig;

import io.restassured.response.Response;

public class RequestConfiguration {

    private RestAssuredConfig config;
    private LogConfig getLogConfigWithAllLogs()
    {
        return LogConfig.logConfig()
                .enablePrettyPrinting(true)
                .enableLoggingOfRequestAndResponseIfValidationFails();
    }

    private LogConfig getLogConfigWithoutLogs()
    {
        return LogConfig.logConfig().enablePrettyPrinting(true);
    }

    enum ReqLogLevel {NONE, ALL}

    public RequestConfiguration(ReqLogLevel logLevel)
    {
        LogConfig logConfig = null;
        switch (logLevel)
        {
            case ALL: {
                logConfig = getLogConfigWithAllLogs();
                break;
            }
            case NONE: {
                logConfig = getLogConfigWithoutLogs();
                break;
            }
        }
        RestAssured.baseURI = "http://dummyapi.io";
        this.config = RestAssured.config()
                .sessionConfig(new SessionConfig().sessionIdName("sessionId"))
                .logConfig(logConfig);
    }

    public Response get(String body){
        return RestAssured.with().config(this.config).body(body).get();
    }
}
