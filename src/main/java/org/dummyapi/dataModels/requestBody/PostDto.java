package org.dummyapi.dataModels.requestBody;

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
    private Integer likes;
    private String link;
    private TagDto tags;
    private String publishDate;
    private Object owner;
}
