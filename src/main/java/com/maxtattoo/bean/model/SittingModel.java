package com.maxtattoo.bean.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@ToString
public class SittingModel implements GenericModel {

    private Long id;
    private LocalDateTime date;
    private String sittingState;
    private double spentHours;
    private int price;
    private String notes;
    private int paid;
    private Long orderId;

    private List<PaintModel> paints = new LinkedList<>();
    private List<NeedleModel> needles = new LinkedList<>();

}
