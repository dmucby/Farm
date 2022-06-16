package com.boyu.farmsharing.model.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 图像
 */
@Data
public class Image implements Serializable {

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
