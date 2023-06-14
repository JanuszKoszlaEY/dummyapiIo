package org.dummyapi.testData;

import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.TagDto;
import org.dummyapi.dataModels.UserDto;

import java.util.ArrayList;
import java.util.List;

public class PostTestData {
    public static PostDto getPostTestData(){
        List<String> testTags = new ArrayList<>();
        testTags.add("First");
        TagDto testTag = TagDto.builder()
                .tags(testTags)
                .build();

        return PostDto.builder()
                .text("Sample Test Post")
                .image("")
                .likes(11)
                .tags(testTag)
                .publishDate("2023-06-06")
                .owner(UserDto.builder()
                        .title("mr")
                        .firstName("Adam")
                        .lastName("Test")
                        .picture("mock")
                        .build())
                .build();
    }
}
