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
@Table(name = "needles")
public class Needle implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long needleId;
    @Column
    private String producer;
    @Column
    private String needleCode;
    @Column
    private String needleSharpening;

}
