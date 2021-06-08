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
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "cityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    @Column
    private String cityName;

}
