package com.maxtattoo.bean.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SittingRequest implements GenericRequest {

    private Long id;
    private String date;
    private double spentHours;
    private int price;
    private String notes;
    private int paid;
    private String state;
    private Long orderId;

}
