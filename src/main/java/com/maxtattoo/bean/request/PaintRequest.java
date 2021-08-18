package com.maxtattoo.bean.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaintRequest implements GenericRequest {

    private Long paintId;
    private String producer;
    private String color;

}
