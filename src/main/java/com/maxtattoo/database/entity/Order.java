package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id_pk")
    private Long orderId;

    @Column(name = "sitting_number")
    private int sittingNumber;

    @Column(name = "order_price")
    private int orderPrice;

    @Column(name = "prepayment")
    private int prepayment;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "client_id_fk")
    private int clientIdFk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_type_id_fk")
    private OrderType orderType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "state_id_fk")
    private State orderState;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id_fk")
    private Set<Sitting> sittings = new HashSet<>();

}
