package com.maxtattoo.dto.statistic;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class OrderStatisticModel implements StatisticObject {

    private String orderType;
    private Integer totalOrders;
    private Integer totalPrice;

}
