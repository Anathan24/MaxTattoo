package com.maxtattoo.bean.model;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString
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
