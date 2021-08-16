package com.maxtattoo.bean.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@Entity
@Table(name = "orders")
public class Order implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id_pk", columnDefinition = "SERIAL", updatable = false)
    private Long id;

    @Column(name = "sitting_number")
    private int sittingNumber;

    @Column(name = "order_price")
    private int orderPrice;

    @Column(name = "state")
    private String orderState;

    @Column(name = "prepayment")
    private int prepayment;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "client_id_fk")
    private Long clientId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_type_id_fk")
    private OrderType orderType;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id_fk")
    private Set<Sitting> sittings = new HashSet<>();

}