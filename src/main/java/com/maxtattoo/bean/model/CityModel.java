package com.maxtattoo.bean.model;

import lombok.*;

@Data
@ToString
public class CityModel implements GenericModel {

    private Long cityId;
    private String name;

}
