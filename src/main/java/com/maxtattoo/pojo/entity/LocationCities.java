package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "locations_cities")
public class LocationCities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locations_cities_id_pk")
    private Long id;

    @Column(name = "location_id_fk")
    private Long locationId;

    @Column(name = "city_id_fk")
    private Long cityId;
}
