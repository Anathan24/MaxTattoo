package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "cities")
public class City implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id_pk")
    private Long id;

    @Column(name = "city_name")
    private String name;

    //TODO Riprogettare la entità city in modo che sia possibile assegnare una stessa città a più locations
    @Column(name = "location_id_fk", updatable = false)
    private Long locationId;

}
