package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "sittings_needles")
public class SittingNeedle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_needle_id_pk")
    private Long id;

    @Column(name = "sitting_id_fk", updatable = false)
    private Long sittingIdFk;

    @Column(name = "needle_id_fk", updatable = false)
    private Long needleIdFk;

}
