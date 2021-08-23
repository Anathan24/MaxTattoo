package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NeedleRequest implements GenericRequest {

    private Long needleId;
    private String producer;
    private String code;
    private String sharpening;

}
