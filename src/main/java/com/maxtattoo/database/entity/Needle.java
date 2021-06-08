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
@Table(name = "needles")
public class Needle {

    @Id
    @Column(name = "needleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String producer;
    @Column
    private String needleCode;
    @Column
    private String needleSharpening;

}
