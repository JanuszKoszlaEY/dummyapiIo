package org.dummyapi.dataModels.requestBody;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TagDto {
    private List<String> tag;
}
