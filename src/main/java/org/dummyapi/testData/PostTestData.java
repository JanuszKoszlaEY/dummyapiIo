package org.dummyapi.testData;


import org.dummyapi.dataModels.requestBody.PostDto;


public class PostTestData {

    public static PostDto postPostData(String userId){
        return PostDto.builder()
                .text("Text In Post")
                .image("string url")
                .likes(5)
                .owner(userId)

            .build();
    }
    public static PostDto postUpdateData(){
        return  PostDto.builder()
                .text("Text In Post")
                .image("string url")
                .likes(5)
            .build();
    }
}
