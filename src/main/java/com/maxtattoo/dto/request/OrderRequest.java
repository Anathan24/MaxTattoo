package com.maxtattoo.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderRequest implements GenericRequest {

    private Long orderId;
    private Integer sittingNumber;
    private Integer avgSittingCost;
    private Integer orderPrice;
    private Integer alreadyPaid;
    private Integer prepayment;
    private String orderState;
    private String startDate;
    private String endDate;
    private String orderType;
    private Long clientId;
    private Long sketchId;
    private Long finalVersionId;

}
