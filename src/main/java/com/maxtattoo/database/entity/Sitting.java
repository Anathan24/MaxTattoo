package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sittings")
public class Sitting implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sittingId;
    @Column
    private Timestamp sittingDate;
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
