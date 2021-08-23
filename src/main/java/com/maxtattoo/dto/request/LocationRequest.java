package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LocationRequest implements GenericRequest {

    private Long locationId;
    private String name;

}
