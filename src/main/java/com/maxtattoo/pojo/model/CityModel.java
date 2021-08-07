package com.maxtattoo.pojo.model;

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
