package com.maxtattoo.bean.model;

import lombok.*;

@Data
@ToString
public class NeedleModel implements GenericModel {

    private Long needleId;
    private String producer;
    private String code;
    private String sharpening;

}
