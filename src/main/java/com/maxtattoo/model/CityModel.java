package com.maxtattoo.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CityModel implements GenericModel {

    private Long id;
    private String name;

}
