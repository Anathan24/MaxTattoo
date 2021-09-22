package com.maxtattoo.dto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "collection")
public class Collection implements GenericEntity {

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

    @Override
    public String toString(){
        return "imageId="+ imageId + ", name=" + name + ", description=" + description;
    }

}
