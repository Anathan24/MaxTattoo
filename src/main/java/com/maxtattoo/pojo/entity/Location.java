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
    @Column(name = "location_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long id;

    @Column(name = "location_name")
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name = "locations_cities", joinColumns = @JoinColumn(name = "location_id_fk"), inverseJoinColumns = @JoinColumn(name = "city_id_fk"))
    private Set<City> cities = new HashSet<>();

}
