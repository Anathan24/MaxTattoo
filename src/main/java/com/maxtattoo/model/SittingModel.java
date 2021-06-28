package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;
import java.sql.Timestamp;

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
    //TODO aggiungere la gestione dello stato
//    private List<PaintModel> paints = new ArrayList<>();
//    private List<NeedleModel> needles = new ArrayList<>();

}
