package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "sittings_needles")
public class SittingNeedle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_needle_id_pk")
    private Long id;

    @Column(name = "sitting_id_fk")
    private Long sittingIdFk;

    @Column(name = "needle_id_fk")
    private Long needleIdFk;

}
