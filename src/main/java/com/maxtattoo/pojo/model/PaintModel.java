package com.maxtattoo.pojo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaintModel implements GenericModel {

    private Long id;
    private String producer;
    private String color;

}
