package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaintRequest implements GenericRequest {

    private Long id;
    private String producer;
    private String color;

}
