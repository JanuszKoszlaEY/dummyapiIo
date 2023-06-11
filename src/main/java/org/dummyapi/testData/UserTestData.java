package org.dummyapi.testData;

import org.dummyapi.dataModels.LocationDto;
import org.dummyapi.dataModels.UserDto;

public class UserTestData {
    public static UserDto getUserDefaultTestData() {
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
    public static UserDto getUserDeletableTestData() {
        return UserDto.builder()
                .title("ms")
                .firstName("first name")
                .lastName("last lastname")
                .gender("female")
                .email("hi357@wo.rld")
                .dateOfBirth("3/3/1995")
                .phone("123120123")
                .picture("https://img.dummyapi.io/photo-1568480541687-16c2f73eea4c.jpg")
                .location(LocationDto.builder()
                        .street("test1")
                        .city("Krakow")
                        .state("Malopolskie")
                        .country("Poland")
                        .timezone("+1:00")
                        .build()
                ).build();

    }
    public static UserDto updateUserTestData(){
        return UserDto.builder()
                .gender("male")
                .build();

    }

}
