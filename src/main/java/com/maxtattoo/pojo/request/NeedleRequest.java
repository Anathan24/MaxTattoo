package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NeedleRequest implements GenericRequest {

    private Long id;
    private String producer;
    private String code;
    private String sharpening;

}
