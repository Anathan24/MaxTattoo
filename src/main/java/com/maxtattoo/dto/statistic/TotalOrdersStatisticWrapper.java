package com.maxtattoo.dto.statistic;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class TotalOrdersStatisticWrapper implements StatisticObject {

    private Integer totalOrders;
    private Integer totalPrice;
    private List<OrderStatisticModel> ordersStatisticByOrderType;

}
