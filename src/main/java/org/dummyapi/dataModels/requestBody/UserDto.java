package org.dummyapi.dataModels.requestBody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String registerDate;
    private String phone;
    private String picture;
    private LocationDto location;
}
