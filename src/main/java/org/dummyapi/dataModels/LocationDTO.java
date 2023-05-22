package org.dummyapi.dataModels;

import lombok.Data;

@Data
public class LocationDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String timezone;
}
