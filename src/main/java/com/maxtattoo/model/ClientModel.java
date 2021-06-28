package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientModel implements GenericModel {

    private Long id;
    private String name;
    private String surname;
    private String gender;
    private String description;

    private LocationModel location;
    private List<OrderModel> orders = new LinkedList<>();
}
