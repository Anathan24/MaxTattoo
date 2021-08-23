package com.maxtattoo.dto.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderTypeModel implements GenericModel {

    private Long orderTypeId;
    private String value;

}
