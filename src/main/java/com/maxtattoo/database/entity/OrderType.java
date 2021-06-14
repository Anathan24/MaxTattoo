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
@Table(name = "orderTypes")
public class OrderType {

    @Id
    @Column(name = "orderTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String orderType;

}
