package com.maxtattoo.database.entity;

import com.maxtattoo.database.entity.interfaces.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Long clientId;
    @Column @NotNull
    private String name;
    @Column @NotNull
    private String surname;
    @Column
    private String gender;
    @Column
    private String description;

}
