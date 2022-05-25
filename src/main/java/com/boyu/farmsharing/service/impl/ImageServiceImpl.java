package com.boyu.farmsharing.service.impl;

import com.boyu.farmsharing.model.domain.Image;
import com.boyu.farmsharing.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public List<Image> ImageRandom(Long imageCx,Long imageCy,Long imageWidth,Long imageHeight) {



       List<Image> images = new ArrayList<>();

        /**
         * 生成三个随机子图片数据
         */
        for (int i = 1; i <= 3 ;i++){
           Image image = new Image();
           image.setImageCx((long) (Math.random() * imageCx));
           image.setImageCy((long) (Math.random() * imageCy));
           image.setHeight((long) (Math.random() * imageHeight));
           image.setWidth((long) (Math.random() * imageWidth));
           images.add(image);
       }

        return images;
    }

}
