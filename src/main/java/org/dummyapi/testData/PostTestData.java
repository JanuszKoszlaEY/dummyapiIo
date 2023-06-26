package org.dummyapi.testData;

import org.dummyapi.dataModels.PostDto;
import org.dummyapi.dataModels.UserDto;

import java.util.ArrayList;
import java.util.List;

public class PostTestData {
    public static PostDto getPostTestData(String userId){
        List<String> testTags = new ArrayList<>();
        testTags.add("firstTag");
        testTags.add("secondTag");

        return PostDto.builder()
                .text("Sample Test Post")
                .image("https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg")
                .likes(0)
                .tags(testTags)
                .owner(UserDto.builder().id(userId).build())
                .build();
    }

    public static PostDto createPostTestData(UserDto userDto){
        List<String> testTags = new ArrayList<>();
        testTags.add("firstTag");
        testTags.add("secondTag");
        testTags.add("thirdTag");

        return PostDto.builder()
                .text("First testing post that we create in REST")
                .image("https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg")
                .likes(0)
                .tags(testTags)
                .owner(userDto.getId())
                .build();
    }

    public static PostDto createIncorrectPostTestData(UserDto userDto){
        List<String> testTags = new ArrayList<>();
        testTags.add("firstTag");
        testTags.add("secondTag");
        testTags.add("thirdTag");

        return PostDto.builder()
                .text("rVI7ELsxVxvr7ysWV6qyuos1FGcjQmMRxgYXV6isLI2OTzICneg")
                .image("https://img.dummyapi.io/photo-1564694202779-bc908c327862.jpg")
                .likes(0)
                .tags(testTags)
                .owner(userDto.getId())
                .build();
    }

    public static PostDto updatePostTestData(UserDto userDto){

        return PostDto.builder()
                .text("This Post is about Test Dogo!")
                .owner(userDto)
                .build();
    }

}
