package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDto {

    private String id;
    private String text;
    private String image;
    private int likes;
    private String link;
    private TagDto tags;
    private String publishDate;
    private UserDto owner;
}
