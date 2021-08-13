package com.maxtattoo.pojo.model;

import lombok.*;

@Data
@ToString
public class PaintModel implements GenericModel {

    private Long id;
    private String producer;
    private String color;

}
