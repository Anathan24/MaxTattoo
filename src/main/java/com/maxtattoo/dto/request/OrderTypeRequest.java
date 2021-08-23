package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderTypeRequest implements GenericRequest{

    private Long id;
    private String value;

}
