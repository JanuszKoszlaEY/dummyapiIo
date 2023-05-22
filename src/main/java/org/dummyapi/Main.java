package org.dummyapi;

import org.dummyapi.utilities.DummyApiProperties;
import org.dummyapi.utilities.PropertiesManager;

public class Main {
    public static void main(String[] args) {
        PropertiesManager.loadProperties();
        String apiUrl = DummyApiProperties.API_BASE_URL.getValue();
        String apiKey = DummyApiProperties.API_KEY.getValue();


        System.out.println("API URL: " + apiUrl);
        System.out.println("API Key: " + apiKey);
    }
}
