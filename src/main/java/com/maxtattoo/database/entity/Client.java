package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id_pk")
    private Long clientId;

    @Column @NotNull
    private String name;

    @Column @NotNull
    private String surname;

    @Column
    private String gender;

    @Column
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "clients_orders", joinColumns = @JoinColumn(name = "client_id_fk"), inverseJoinColumns = @JoinColumn(name = "order_id_fk"))
    private Set<Order> orders = new HashSet<>();

}
