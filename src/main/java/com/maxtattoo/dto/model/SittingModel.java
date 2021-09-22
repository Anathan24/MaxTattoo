package com.maxtattoo.dto.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
public class SittingModel implements GenericModel {

    private Long sittingId;
    private LocalDateTime date;
    private String sittingState;
    private Double spentHours;
    private Integer paid;
    private String notes;
    private Long orderId;
    private CollectionModel image;

    private List<PaintModel> paints = new LinkedList<>();
    private List<NeedleModel> needles = new LinkedList<>();

}
