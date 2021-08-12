package com.maxtattoo.pojo.model;

import com.maxtattoo.utils.StateEnum;
import lombok.*;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class SittingModel implements GenericModel {

    private Long id;
    private Timestamp date;
    private double spentHours;
    private int price;
    private String notes;
    private int paid;
    private Long orderId;
    private StateEnum state;
    private List<PaintModel> paints = new LinkedList<>();
    private List<NeedleModel> needles = new LinkedList<>();

}
