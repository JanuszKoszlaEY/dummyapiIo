package org.dummyapi.dataModels.requestBody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LocationDto {
     private String street;
     private String city;
     private String state;
     private String country;
     private String timezone;
}
