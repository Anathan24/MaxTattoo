package com.maxtattoo.model;

import com.maxtattoo.model.interfaces.GenericModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StateModel implements GenericModel {

    private Long id;
    private String value;

}
