package com.maxtattoo.model;

import com.maxtattoo.utils.StateEnum;
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
    private StateEnum state;

    private List<SittingModel> sittings = new LinkedList<>();
}
