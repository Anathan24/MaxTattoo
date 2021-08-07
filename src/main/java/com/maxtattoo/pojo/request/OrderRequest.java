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
    private Date startDate;
    private Date endDate;
    private Long clientId;
    private Long orderTypeId;
    private Long orderState;

}
