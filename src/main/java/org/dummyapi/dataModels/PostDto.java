package org.dummyapi.dataModels;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class PostDto {

    private String id;
    private String text;
    private String image;
    private int likes;
    private String link;
    private List<TagDto> tags;
    private String publishDate;
    private UserDto owner;
}
