package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long cityId;

    @Column(name = "city_name")
    private String name;

}
