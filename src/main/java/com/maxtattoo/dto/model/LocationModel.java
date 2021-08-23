package com.maxtattoo.dto.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class LocationModel implements GenericModel {

    private Long locationId;
    private String name;
    private List<CityModel> cites = new ArrayList<>();

}
