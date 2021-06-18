package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.BaseEntity;
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
public class Order implements BaseEntity {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column
    private int sittingNumber;
    @Column
    private int orderPrice;
    @Column
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
