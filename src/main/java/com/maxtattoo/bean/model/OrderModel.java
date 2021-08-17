package com.maxtattoo.bean.model;

import lombok.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class OrderModel implements GenericModel {

    private Long id;
    private int sittingNumber;
    private int orderPrice;
    private String orderState;
    private int prepayment;
    private LocalDate startDate;
    private LocalDate endDate;

    private OrderTypeModel orderType;

    private List<SittingModel> sittings = new LinkedList<>();
}
