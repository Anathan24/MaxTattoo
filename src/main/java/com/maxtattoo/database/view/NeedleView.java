package com.maxtattoo.database.view;

import com.maxtattoo.database.view.interfaces.GenericView;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NeedleView implements GenericView {

    private Long needleId;
    private String needleProducer;
    private String needleCode;
    private String needleSharpening;
}
