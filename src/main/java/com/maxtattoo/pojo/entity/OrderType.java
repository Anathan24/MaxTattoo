package com.maxtattoo.pojo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "order_types")
public class OrderType implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_type_id_pk", columnDefinition = "SERIAL")
    private Long id;

    @Column(name = "type")
    private String value;

}
