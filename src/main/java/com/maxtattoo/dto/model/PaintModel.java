package com.maxtattoo.dto.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaintModel implements GenericModel {

    private Long paintId;
    private String producer;
    private String color;

}
