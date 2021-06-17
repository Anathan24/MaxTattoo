package com.maxtattoo.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sittings")
public class Sittings {

    @Id
    @Column(name = "sittingId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @NotNull
    private Date sittingDtae;
    @Column
    private double spentHours;
    @Column(columnDefinition = "int default 0")
    private int sittingPrice;
    @Column
    private String sittingNote;

    @Column
    private int stateId;
    @Column
    private int ordersId;

}
