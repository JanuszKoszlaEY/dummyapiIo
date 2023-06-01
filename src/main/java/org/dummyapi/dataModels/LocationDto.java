package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
    private String street;
    private String city;
    private String state;
    private String country;
    private String timezone;
}
