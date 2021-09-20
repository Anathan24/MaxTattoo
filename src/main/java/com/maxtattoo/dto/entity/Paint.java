package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "paints")
public class Paint implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paint_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long paintId;

    @Column(name = "paint_producer")
    private String producer;

    @Column(name = "color")
    private String color;

}
