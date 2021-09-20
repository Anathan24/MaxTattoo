package com.maxtattoo.dto.model;

import lombok.Data;

@Data
public class NeedleModel implements GenericModel {

    private Long needleId;
    private String producer;
    private String code;
    private String sharpening;

}
