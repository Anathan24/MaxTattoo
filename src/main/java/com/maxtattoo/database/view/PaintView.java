package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaintView implements GenericView {

    private Long paintId;
    private String paintProducer;
    private String paintColor;
}
