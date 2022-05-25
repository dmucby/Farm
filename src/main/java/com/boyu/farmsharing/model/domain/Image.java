package com.boyu.farmsharing.model.domain;

import lombok.Data;

/**
 * 图像
 */
@Data
public class Image {

    /**
     * 图像长
     */
    private Long imageCx;

    /**
     * 图像宽
     */
    private Long imageCy;

    /**
     * 图像宽度
     */
    private Long width;

    /**
     * 图像高
     */
    private Long height;
}
