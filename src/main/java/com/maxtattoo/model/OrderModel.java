package com.maxtattoo.model;

import com.maxtattoo.model.enums.OrderType;
import com.maxtattoo.model.enums.State;
import lombok.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderModel {

    private Long orderId;
    private int sittingNumber;
    private int orderPrice;
    private int prepayment;
    private Date startDate;
    private Date endDate;

    private OrderType orderType;
    private State state;
    private List<SittingModel> sittings = new ArrayList<>();

}
