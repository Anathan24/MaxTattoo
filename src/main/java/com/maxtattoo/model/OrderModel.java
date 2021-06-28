package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;
import java.sql.Date;
import java.util.ArrayList;
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

    private String orderType;
    private String state;

    private List<SittingModel> sittings = new ArrayList<>();
}
