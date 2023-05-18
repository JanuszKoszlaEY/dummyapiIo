package org.dummyapi.testData;

import org.dummyapi.dataModels.requestBody.LocationDto;
import org.dummyapi.dataModels.requestBody.UserDto;

public class UserTestData {
    public static LocationDto location(){
        return LocationDto.builder()
            .street("Wolska")
            .city("Piła")
            .state("Wielkopolskie")
            .country("Poland")
            .timezone("9.00")
            .build();
    }
    public static UserDto userPostData(){
        return UserDto.builder()
            .title("mr")
            .firstName("Jacek")
            .lastName("Wokulski")
            .picture("Picture")
            .gender("male")
            .email("jacek.Wolski1@mail.com")
            .dateOfBirth("1990-01-01")
            .phone("11223345566")
            .location(location())
            .build();
    }
    public static UserDto userUpdateData(){
        return  UserDto.builder()
            .title("mr")
            .firstName("Jacek")
            .lastName("Wokulski")
            .picture("change")
            .gender("man")
            .dateOfBirth("1990-01-01")
            .phone("11223345566")
            .location(location())
            .build();
    }
}
