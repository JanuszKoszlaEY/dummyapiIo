package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.dummyapi.configuration.DummyApiProperties;
import org.dummyapi.configuration.PropertiesManager;
import org.dummyapi.dataModels.UserDto;
import org.dummyapi.testData.UserTestData;


public class UserController {
    public Response createUser(UserDto userDTO) {
        PropertiesManager.loadProperties();
        String path = "/api/users";
        String url = DummyApiProperties.API_BASE_URL.getValue() + path;
        RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        return RestAssured.given().config(config).body(userDTO).post(url);
    }
}
