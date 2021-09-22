package com.maxtattoo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CollectionRequest {

    private Long imageId;
    private String name;
    private byte[] content;
    private String description;

    @Override
    public String toString(){
        return "imageId="+ imageId + ", name=" + name + ", description=" + description;
    }
}
