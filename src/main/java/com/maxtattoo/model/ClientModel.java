package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientModel implements GenericModel {

    private Long clientId;
    private String name;
    private String surname;
    private String gender;
    private String description;

    private LocationModel location;
    private List<OrderModel> orders = new ArrayList<>();
}