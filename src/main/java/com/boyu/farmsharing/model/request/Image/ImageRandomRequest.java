package com.boyu.farmsharing.model.request.Image;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImageRandomRequest implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    private String imageString;

}
