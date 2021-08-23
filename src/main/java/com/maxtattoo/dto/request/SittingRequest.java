package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SittingRequest implements GenericRequest {

    private Long sittingId;
    private String date;
    private String sittingState;
    private Double spentHours;
    private Integer paid;
    private String notes;
    private Long orderId;
}
