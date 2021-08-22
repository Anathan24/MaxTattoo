package com.maxtattoo.bean.model;

import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class OrderModel implements GenericModel {

    private Long orderId;
    private Integer sittingNumber;
    private Integer avgSittingCost;
    private Integer orderPrice;
    private Integer alreadyPaid;
    private Integer prepayment;
    private String orderState;
    private LocalDate startDate;
    private LocalDate endDate;

    private OrderTypeModel orderType;

    private List<SittingModel> sittings = new LinkedList<>();
}
