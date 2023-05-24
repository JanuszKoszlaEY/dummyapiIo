package org.dummyapi.utilities;

public enum DummyApiProperties {
    API_BASE_URL("api.base.url"),
    API_KEY("api.key"),
    API_LOGLEVEL("api.log.level");
    private final String key;



    DummyApiProperties(String key) {
        this.key = key;
    }

    public String getValue() {
        return PropertiesManager.getProperty(key);
    }
}
