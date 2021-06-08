package com.maxtattoo.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "INT default = 1")
    private int sittingNumber;
    @Column(columnDefinition = "INT default = 0")
    private int orderPrice;
    @Column(columnDefinition = "INT default = 0")
    private int prepayment;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String orderType;

    @Column
    private int stateId;
    @Column
    private int orderTypeId;
    @Column
    private int clientId;

}
