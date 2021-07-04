package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SittingModel implements GenericModel {

    private Long id;
    private Timestamp date;
    private double hours;
    private int price;
    private String note;
    private int paid;
    private Long orderId;
    private StateModel state;
    private List<PaintModel> paints = new LinkedList<>();
    private List<NeedleModel> needles = new LinkedList<>();

}
