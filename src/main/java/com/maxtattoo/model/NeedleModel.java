package com.maxtattoo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NeedleModel implements GenericModel{

    private Long needleId;
    private String producer;
    private String needleCode;
    private String needleSharpening;

}
