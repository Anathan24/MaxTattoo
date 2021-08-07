package com.maxtattoo.pojo.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LocationModel implements GenericModel {

    private Long id;
    private String name;
    private List<CityModel> cites = new ArrayList<>();

}
