package com.maxtattoo.response;

import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderTypeResponse implements GenericResponse {

    private Long id;
    private String value;

}
