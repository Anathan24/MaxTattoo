package com.maxtattoo.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "needles")
public class Needle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "needle_id_pk")
    private Long needleId;

    @Column(name = "needle_producer")
    private String needleProducer;

    @Column(name = "needle_code")
    private String needleCode;

    @Column(name = "needle_sharpening")
    private String needleSharpening;

}
