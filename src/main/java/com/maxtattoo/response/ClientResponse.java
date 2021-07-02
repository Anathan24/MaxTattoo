package com.maxtattoo.response;

import com.maxtattoo.model.LocationModel;
import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ClientResponse implements GenericResponse {

    private Long id;
    private String name;
    private String surname;
    private String gender;
    private String description;

    private LocationModel location;
    private List<OrderResponse> orders = new LinkedList<>();
}
