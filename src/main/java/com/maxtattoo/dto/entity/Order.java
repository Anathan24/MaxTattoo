package com.maxtattoo.dto.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id_pk", columnDefinition = "SERIAL")
    private Long orderId;

    @Column(name = "sitting_number")
    private Integer sittingNumber;

    @Column(name = "avg_sitting_cost")
    private Integer avgSittingCost;

    @Column(name = "order_price")
    private Integer orderPrice;

    @Column(name = "already_paid")
    private Integer alreadyPaid;

    @Column(name = "prepayment")
    private Integer prepayment;

    @Column(name = "state")
    private String orderState;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "client_id_fk")
    private Long clientId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_type_id_fk")
    private OrderType orderType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initial_image_state_id_fk")
    private Collection sketch;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "final_image_state_id_fk")
    private Collection finalVersion;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id_fk", updatable = false)
    private Set<Sitting> sittings = new HashSet<>();

}
