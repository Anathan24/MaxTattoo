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
public class Sitting {

    @Id
    @Column(name = "sittingId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sittingId;
    @Column @NotNull
    private Date sittingDate;
    @Column
    private double spentHours;
    @Column
    private int sittingPrice;
    @Column
    private String sittingNote;

    @Column
    private int stateId;
    @Column
    private int orderId;

}
