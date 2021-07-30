package com.maxtattoo.model.statistic;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TotalOrdersWrapper {

    private Integer totalOrders;
    private Integer totalPrice;
    private List<OrderStatistic> ordersStatisticByType = new LinkedList<>();

}
