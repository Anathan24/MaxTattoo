package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long imageId;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private byte[] content;

    @Column(name = "description")
    private String description;

}
