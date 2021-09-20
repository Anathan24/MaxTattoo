package com.maxtattoo.dto.model;

import lombok.Data;

@Data
public class OrderTypeModel implements GenericModel {

    private Long orderTypeId;
    private String value;

}
