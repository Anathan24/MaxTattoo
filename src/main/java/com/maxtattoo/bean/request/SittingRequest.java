package com.maxtattoo.bean.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SittingRequest implements GenericRequest {

    private Long id;
    private String date;
    private Double spentHours;
    private Integer paid;
    private String notes;
    private String state;
    private Long orderId;

}
