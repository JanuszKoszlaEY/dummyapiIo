package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String dateOfBirth;
    private String registeredDate;
    private String phone;
    private String picture;
    private LocationDTO location;

}
