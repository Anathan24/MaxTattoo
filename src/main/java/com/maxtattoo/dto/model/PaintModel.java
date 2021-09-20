package com.maxtattoo.dto.model;

import lombok.Data;

@Data
public class PaintModel implements GenericModel {

    private Long paintId;
    private String producer;
    private String color;

}
