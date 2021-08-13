package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "clients")
public class Client implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String gender;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id_fk")
    private Location location;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_fk")
    private Set<Order> orders = new HashSet<>();

}
