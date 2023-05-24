package org.dummyapi.requests;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.dummyapi.utilities.DummyApiProperties;
import org.dummyapi.utilities.PropertiesManager;
import org.json.JSONObject;


public class UserController {
    public Response createUser() {
        String path = "/api/users";

        JSONObject body = new JSONObject();
        body.put("title", "mr");
        body.put("firstName", "test name");
        body.put("lastName", "test lastname");
        body.put("gender", "male");
        body.put("email", "test@example.com");
        body.put("dateOfBirth", "2/3/1995");
        body.put("phone", "123123123");
        body.put("picture", "https://img.dummyapi.io/photo-1568480541687-16c2f73eea4c.jpg");
        JSONObject location = new JSONObject();
        location.put("street","test");
        location.put("city","wroclaw");
        location.put("state","dolnoslask");
        location.put("country","poland");
        location.put("timezone","+1:00");
        body.put("location", location);

        String url = DummyApiProperties.API_BASE_URL.getValue() + path;
        RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        Response response = RestAssured.given().config(config).contentType(ContentType.JSON).body(body.toString()).post(url);

        System.out.println("Response: " + response.asString());
        return response;
    }

    public static void main(String[] args) {
        PropertiesManager.loadProperties();
        UserController userController = new UserController();
        userController.createUser();
    }
}
