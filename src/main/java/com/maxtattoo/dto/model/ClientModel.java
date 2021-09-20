package com.maxtattoo.dto.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ClientModel implements GenericModel {

    private Long clientId;
    private String name;
    private String surname;
    private String gender;
    private String phoneNumber;
    private String description;

    private LocationModel location;
    private List<OrderModel> orders = new LinkedList<>();
}
