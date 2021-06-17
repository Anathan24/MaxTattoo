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
@Table(name = "sittings_paints")
public class SittingPaint {

    @Id
    @Column(name = "sittingPaintId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sittingPaintId;

    @Column
    private int sittingId;
    @Column
    private int paintId;

}
