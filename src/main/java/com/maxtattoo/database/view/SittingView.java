package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "SittingView")
public class SittingView implements GenericView {

    private Long sittingId;
    private LocalDateTime sittingDate;
    private int spentHours;
    private double sittingPrice;
    private String sittingNote;

    private List<PaintView> paints;
    private List<NeedleView> needles;
}
