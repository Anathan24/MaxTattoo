package com.maxtattoo.pojo.request;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

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
