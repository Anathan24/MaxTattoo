package com.maxtattoo.bean.model;

import lombok.*;

@Data
@ToString
public class NeedleModel implements GenericModel {

    private Long id;
    private String producer;
    private String code;
    private String sharpening;

}
