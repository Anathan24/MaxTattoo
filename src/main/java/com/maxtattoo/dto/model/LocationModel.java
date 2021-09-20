package com.maxtattoo.dto.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationModel implements GenericModel {

    private Long locationId;
    private String name;
    private List<CityModel> cites = new ArrayList<>();

}
