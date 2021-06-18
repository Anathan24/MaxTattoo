package com.maxtattoo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaintModel {

    private Long paintId;
    private String producer;
    private String color;

}
