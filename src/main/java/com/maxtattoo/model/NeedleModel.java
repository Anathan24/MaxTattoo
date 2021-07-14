package com.maxtattoo.model;

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
