package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "NeedleView")
public class PaintView implements GenericView {

    @Id
    private Long paintId;
    private String paintProducer;
    private String paintColor;
}
