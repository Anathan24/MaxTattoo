package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "clients")
public class Client implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "telephone_number")
    private String phoneNumber;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id_fk")
    private Location location;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk", updatable = false)
    private Set<Order> orders = new HashSet<>();

}
