package org.dummyapi.configuration;

public interface EnvironmentProperties {
    String URL = PropertyManager.getInstance().getURL();
    String LOG_LEVEL = PropertyManager.getInstance().getLog().toUpperCase();
    String APP_ID = PropertyManager.getInstance().getAppId();
}
