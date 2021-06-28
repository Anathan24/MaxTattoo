package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NeedleModel implements GenericModel {

    private Long id;
    private String producer;
    private String code;
    private String sharpening;

}
