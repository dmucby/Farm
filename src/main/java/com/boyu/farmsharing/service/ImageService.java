package com.boyu.farmsharing.service;

import com.boyu.farmsharing.model.domain.Image;

import java.util.List;

public interface ImageService  {

    /**
     * 输出随机图片
     * @param imageCx x
     * @param imageCy y
     * @param imageWidth 宽度
     * @param imageHeight 长度
     * @return 随机图片
     */
    List<Image> ImageRandom(Long imageCx, Long imageCy, Long imageWidth, Long imageHeight);

}
