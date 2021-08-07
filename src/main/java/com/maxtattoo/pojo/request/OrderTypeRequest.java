package com.maxtattoo.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderTypeRequest implements GenericRequest{

    @JsonProperty
    private Long id;
    @JsonProperty(required = true)
    private String value;

}
