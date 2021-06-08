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
@Table(name = "sittings_needles")
public class Sitting_Needle {

    @Id
    @Column(name = "sittingNeedleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int sittingId;
    @Column
    private int needleId;

}
