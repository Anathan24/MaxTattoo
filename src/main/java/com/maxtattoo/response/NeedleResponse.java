package com.maxtattoo.response;

import com.maxtattoo.response.interfaces.GenericResponse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class NeedleResponse implements GenericResponse {

    private Long id;
    private String producer;
    private String code;
    private String sharpening;

}
