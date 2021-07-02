package com.maxtattoo.response;

import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.*;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SittingResponse implements GenericResponse {

    private Long id;
    private Timestamp date;
    private double hours;
    private int price;
    private String note;
    private Long orderId;
    private StateResponse state;
    private List<PaintResponse> paints = new LinkedList<>();
    private List<NeedleResponse> needles = new LinkedList<>();

}
