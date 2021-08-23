package com.maxtattoo.dto.statistic;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderStatistic {

    private String orderType;
    private Integer totalOrders;
    private Integer totalPrice;
}
