package com.maxtattoo.dto.model;

import lombok.Data;

@Data
public class ImageModel implements GenericModel{

    private Long imageId;
    private String name;
    private byte[] content;
    private String description;

}
