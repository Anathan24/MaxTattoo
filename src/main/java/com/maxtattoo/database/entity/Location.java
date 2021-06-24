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
@Table(name = "locations")
public class Location implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locationid")
    private Long locationId;

    @Column
    private String name;
    @Column
    private int clientId;
    @Column
    private int cityId;

}
