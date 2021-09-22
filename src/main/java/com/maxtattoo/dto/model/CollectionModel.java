package com.maxtattoo.dto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionModel implements GenericModel {

    private Long imageId;
    private String name;
    private byte[] content;
    private String description;

    @Override
    public String toString(){
        return "imageId="+ imageId + ", name=" + name + ", description=" + description;
    }

}
