package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientRequest implements GenericRequest {

    private Long id;
    private String name;
    private String surname;
    private String gender;
    private String description;
    private Long locationId;

}
