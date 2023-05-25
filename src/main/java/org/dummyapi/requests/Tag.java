package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.dummyapi.configuration.DummyApiProperties;
import org.dummyapi.configuration.PropertiesManager;

public class Tag {
    public Response getTag(){
        PropertiesManager.loadProperties();
        String path = "/tag";
        String url = DummyApiProperties.API_BASE_URL.getValue() + path;
        RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        return RestAssured.given().config(config).get(url);
    }
}
