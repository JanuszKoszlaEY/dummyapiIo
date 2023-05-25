package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String timezone;
}
