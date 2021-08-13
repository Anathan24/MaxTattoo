package com.maxtattoo.pojo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class OrderTypeModel implements GenericModel {

    private Long id;
    private String value;

}
