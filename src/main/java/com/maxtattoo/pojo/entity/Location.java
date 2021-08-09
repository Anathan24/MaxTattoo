package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "locations")
public class Location implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id_pk")
    private Long id;

    @Column(name = "location_name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id_fk", updatable = false)
    private Set<City> cities = new HashSet<>();

}
