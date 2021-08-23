package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientRequest implements GenericRequest {

    private Long clientId;
    private String name;
    private String surname;
    private String gender;
    private String phoneNumber;
    private String description;
    private Long locationId;

}
