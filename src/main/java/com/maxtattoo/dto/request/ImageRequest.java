package com.maxtattoo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageRequest {

    private Long imageId;
    private String name;
    private byte[] content;
    private String description;

}
