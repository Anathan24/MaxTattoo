package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CityRequest implements GenericRequest{

    private Long id;
    private String name;
    private Long locationId;

}
