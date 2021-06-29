package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LocationModel implements GenericModel {

    private Long locationId;
    private String description;
    private List<CityModel> name = new ArrayList<>();

}
