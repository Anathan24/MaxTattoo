package com.maxtattoo.bean.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderRequest implements GenericRequest {

    private Long id;
    private int sittingNumber;
    private int orderPrice;
    private int prepayment;
    private String startDate;
    private String endDate;
    private Long clientId;
    private String orderType;
    private String orderState;

}
