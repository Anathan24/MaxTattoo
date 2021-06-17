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
@Table(name = "states")
public class State implements BaseEntity{

    @Id
    @Column(name = "stateId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateId;
    @Column
    private String stateName;

}
