package com.maxtattoo.dto.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
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
