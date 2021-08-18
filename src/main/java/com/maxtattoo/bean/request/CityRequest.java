package com.maxtattoo.bean.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CityRequest implements GenericRequest{

    private Long cityId;
    private String name;

}
