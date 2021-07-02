package com.maxtattoo.response;

import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PaintResponse implements GenericResponse {

    private Long id;
    private String producer;
    private String color;

}
