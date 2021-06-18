package com.maxtattoo.model;

import com.maxtattoo.model.enums.City;
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
    //TODO da specificare i dettagli

    private Long locationId;
    private String description;
    private List<City> name = new ArrayList<>();

}
