package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class SittingRequest implements GenericRequest {

    private Long id;
    private String date;
    private double spentHours;
    private int price;
    private String notes;
    private int paid;
    private String sittingState;
    private Long orderId;

}
