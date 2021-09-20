package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sittings_paints")
public class SittingPaint implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_paint_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long spId;

    @Column(name = "sitting_id_fk", updatable = false)
    private Long sittingIdFk;

    @Column(name = "paint_id_fk", updatable = false)
    private Long paintIdFk;

}
