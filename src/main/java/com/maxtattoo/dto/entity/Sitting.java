package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "sittings")
public class Sitting implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long sittingId;

    @Column(name = "date_time")
    private Timestamp dateTime;

    @Column(name = "state")
    private String sittingState;

    @Column(name = "spent_hours")
    private Double spentHours;

    @Column(name = "paid")
    private Integer paid;

    @Column(name = "notes")
    private String notes;

    @Column(name = "order_id_fk", updatable = false)
    private Long orderId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_paints", joinColumns = @JoinColumn(name = "sitting_id_fk", updatable = false), inverseJoinColumns = @JoinColumn(name = "paint_id_fk", updatable = false))
    private Set<Paint> paints = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_needles", joinColumns = @JoinColumn(name = "sitting_id_fk", updatable = false), inverseJoinColumns = @JoinColumn(name = "needle_id_fk", updatable = false))
    private Set<Needle> needles = new HashSet<>();

}
