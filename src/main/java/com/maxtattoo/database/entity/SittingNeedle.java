package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.BaseEntity;
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
public class SittingNeedle implements BaseEntity {

    @Id
    @Column(name = "sittingNeedleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sittingNeedleId;

    @Column
    private int sittingId;
    @Column(unique = true)
    private int needleId;

}
