package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
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
public class SittingNeedle implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sittingneedleid")
    private Long sittingNeedleId;

    @Column
    private Long sittingId;
    @Column(unique = true)
    private Long needleId;

}
