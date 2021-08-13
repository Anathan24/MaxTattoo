package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "clients")
public class Client implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id_pk", columnDefinition = "SERIAL")
    private Long id;

    @Column @NotNull
    private String name;

    @Column @NotNull
    private String surname;

    @Column
    private String gender;

    @Column
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id_fk")
    private Location location;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk", updatable = false)
    private Set<Order> orders = new HashSet<>();

}
