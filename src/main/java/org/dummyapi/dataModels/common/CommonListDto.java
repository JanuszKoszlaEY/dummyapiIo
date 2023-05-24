package org.dummyapi.dataModels.common;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class CommonListDto {
    private List<Object> data;
    private Integer total;
    private Integer number;
    private Integer limit;
}
