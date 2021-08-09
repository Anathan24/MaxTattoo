package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "sittings")
public class Sitting implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_id_pk")
    private Long id;

    @Column(name = "sitting_date")
    private Timestamp date;

    @Column(name = "spent_hours")
    private double spentHours;

    @Column(name = "sitting_price")
    private int price;

    @Column(name = "sitting_note")
    private String notes;

    @Column(name = "paid")
    private int paid;

    @Column(name = "order_id_fk", updatable = false)
    private Long orderId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id_fk")
    private State sittingState;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_paints", joinColumns = @JoinColumn(name = "sitting_id_fk", updatable = false), inverseJoinColumns = @JoinColumn(name = "paint_id_fk", updatable = false))
    private Set<Paint> paints = new HashSet<>();

    @ManyToMany(cascade =  CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_needles", joinColumns = @JoinColumn(name = "sitting_id_fk", updatable = false), inverseJoinColumns = @JoinColumn(name = "needle_id_fk", updatable = false))
    private Set<Needle> needles = new HashSet<>();

}
