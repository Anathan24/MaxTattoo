package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "needles")
public class Needle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "needle_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long needleId;

    @Column(name = "needle_producer")
    private String producer;

    @Column(name = "needle_code")
    private String code;

    @Column(name = "needle_sharpening")
    private String sharpening;

}
