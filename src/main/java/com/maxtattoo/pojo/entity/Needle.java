package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "needles")
public class Needle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "needle_id_pk")
    private Long id;

    @Column(name = "needle_producer")
    private String producer;

    @Column(name = "needle_code")
    private String code;

    @Column(name = "needle_sharpening")
    private String sharpening;

}
