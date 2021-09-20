package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sittings_needles")
public class SittingNeedle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_needle_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long snId;

    @Column(name = "sitting_id_fk", updatable = false)
    private Long sittingIdFk;

    @Column(name = "needle_id_fk", updatable = false)
    private Long needleIdFk;

}
