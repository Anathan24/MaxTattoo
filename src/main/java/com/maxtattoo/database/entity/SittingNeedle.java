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
@Table(name = "sitting_needles")
public class SittingNeedle implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sittingNeedleId;

    @Column
    private Long sittingId;
    @Column(unique = true)
    private Long needleId;

}
