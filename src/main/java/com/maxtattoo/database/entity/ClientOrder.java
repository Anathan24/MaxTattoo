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
@Table(name = "clients_orders")
public class ClientOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_order_id_pk")
    private Long clientOrderId;

    @Column(name = "client_id_fk")
    private Long clientIdFk;

    @Column(name = "order_id_fk")
    private Long orderIdFk;

}
