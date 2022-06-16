package com.boyu.farmsharing.service.impl;

import com.boyu.farmsharing.model.domain.Image;
import com.boyu.farmsharing.Util.ImageUtil;
import com.boyu.farmsharing.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ImageServiceImplTest {

    @Resource
    private ImageService imageService;

//    @Test
//    void ImageRandomTest(){
//        List<Image> Images = new ArrayList<>();
//
//        long imagesCx = 100L;
//        long imagesCy = 100L;
//        long weight = 100L;
//        long height = 100L;
//
//        Images  = imageService.ImageRandom(imagesCx,imagesCy,weight,height);
//
//        for(Image image : Images){
//            System.out.println("=====================");
//            System.out.println("随机x为" + image.getImageCx());
//            System.out.println("随机y为" + image.getImageCy());
//            System.out.println("随机width为" + image.getWidth());
//            System.out.println("随机height为" + image.getHeight());
//        }
//
//    }
//
//
//    @Test
//    void ImageBase64Test() throws IOException {
//        String imageStr = ImageUtil.GetImageStr("D://test//下载/java265.jpg");
//        System.out.println(imageStr);
//        System.out.println(ImageUtil.GenerateImage(imageStr).getHeight());
//    }
}