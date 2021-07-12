package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "sittings_paints")
public class SittingPaint implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sitting_paint_id_pk")
    private Long sittingPaintId;

    @Column(name = "sitting_id_fk")
    private Long sittingIdFk;

    @Column(name = "paint_id_fk")
    private Long paintIdFk;

    public SittingPaint(Long sittingId, Long paintId){
        this.sittingIdFk = sittingId;
        this.paintIdFk = paintId;
    }

}
