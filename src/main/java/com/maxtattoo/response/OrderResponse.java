package com.maxtattoo.response;

import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.*;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderResponse implements GenericResponse {

    private Long id;
    private int sittingNumber;
    private int orderPrice;
    private int prepayment;
    private Date startDate;
    private Date endDate;

    private OrderTypeResponse orderType;
    private StateResponse state;

    private List<SittingResponse> sittings = new LinkedList<>();
}
