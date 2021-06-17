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
@Table(name = "paints")
public class Paint implements BaseEntity{

    @Id
    @Column(name = "paintId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paintId;
    @Column
    private String producer;
    @Column
    private String color;

}
