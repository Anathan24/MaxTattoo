package com.maxtattoo.model;

import lombok.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderModel implements GenericModel {

    private Long id;
    private int sittingNumber;
    private int orderPrice;
    private int prepayment;
    private Date startDate;
    private Date endDate;

    private OrderTypeModel orderType;
    private StateModel state;

    private List<SittingModel> sittings = new LinkedList<>();
}
