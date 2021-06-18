package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.BaseEntity;
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
public class OrderType implements BaseEntity {

    @Id
    @Column(name = "orderTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderTypeId;
    @Column
    private String type;

}
