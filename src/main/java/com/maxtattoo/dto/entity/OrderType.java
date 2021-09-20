package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_types")
public class OrderType implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_type_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long orderTypeId;

    @Column(name = "type")
    private String value;

}
