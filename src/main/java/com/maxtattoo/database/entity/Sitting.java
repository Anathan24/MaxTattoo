package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_paints", joinColumns = @JoinColumn(name = "sitting_id_fk"), inverseJoinColumns = @JoinColumn(name = "paint_id_fk"))
    private Set<Paint> paints = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "sittings_needles", joinColumns = @JoinColumn(name = "sitting_id_fk"), inverseJoinColumns = @JoinColumn(name = "needle_id_fk"))
    private Set<Needle> needles = new HashSet<>();

}
