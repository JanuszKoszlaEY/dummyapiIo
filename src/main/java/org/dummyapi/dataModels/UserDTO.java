package org.dummyapi.dataModels;

import lombok.Data;

@Data
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
