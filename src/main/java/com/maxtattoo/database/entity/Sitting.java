package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
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
public class Sitting implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_id_pk")
    private Long sittingId;

    @Column(name = "sitting_date")
    private Timestamp sittingDate;

    @Column(name = "spent_hours")
    private double spentHours;

    @Column(name = "sitting_price")
    private int sittingPrice;

    @Column(name = "sitting_note")
    private String sittingNote;

    @Column(name = "state_id_fk")
    private int stateId;

    @Column(name = "order_id_fk")
    private int orderId;

}
