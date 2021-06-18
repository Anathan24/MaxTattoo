package com.maxtattoo.model;

import com.maxtattoo.model.enums.State;
import lombok.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class SittingModel implements GenericModel{

    private Long sittingId;
    private Timestamp sittingDate;
    private double spentHours;
    private int sittingPrice;
    private String sittingNote;

    private State state;
    private List<PaintModel> paints = new ArrayList<>();
    private List<NeedleModel> needles = new ArrayList<>();

}
