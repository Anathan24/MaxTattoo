package com.maxtattoo.bean.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "locations_cities")
public class LocationCity implements GenericEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locations_cities_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long lcId;

    @Column(name = "location_id_fk")
    private Long locationIdFk;

    @Column(name = "city_id_fk")
    private Long cityIdFk;
}
