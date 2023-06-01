package org.dummyapi.testData;

import org.dummyapi.dataModels.LocationDto;
import org.dummyapi.dataModels.UserDto;

public class UserTestData {
    public static UserDto getUserTestData() {
        return UserDto.builder()
                .title("mr")
                .firstName("test name")
                .lastName("test lastname")
                .gender("male")
                .email("hello@wo.rld")
                .dateOfBirth("2/3/1995")
                .phone("123123123")
                .picture("https://img.dummyapi.io/photo-1568480541687-16c2f73eea4c.jpg")
                .location(LocationDto.builder()
                        .street("test")
                        .city("Wroclaw")
                        .state("Dolnoslask")
                        .country("Poland")
                        .timezone("+1:00")
                        .build()
                ).build();
    }

}
