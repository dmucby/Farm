package com.boyu.farmsharing.Controller;


import com.boyu.farmsharing.Constant.ImageConstant;
import com.boyu.farmsharing.Util.ImageUtil;
import com.boyu.farmsharing.common.BaseResponse;
import com.boyu.farmsharing.common.ResultUtils;
import com.boyu.farmsharing.model.domain.Image;
import com.boyu.farmsharing.model.request.ImageRandomRequest;
import com.boyu.farmsharing.service.ImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

@RequestMapping("/image")
@RestController  // 返回Json
public class ImageController {

    @Resource
    ImageService imageService;

    @PostMapping("/random")
    public BaseResponse<List<Image>> Random(@RequestBody ImageRandomRequest imageRandomRequest){
        if (imageRandomRequest == null) {
            return null;
        }

        String imageString = imageRandomRequest.getImageString();

        BufferedImage image = null;

        try {
            image = ImageUtil.GenerateImage(imageString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Long imageWidth = null;
        if (image != null) {
            imageWidth = (long) image.getWidth();
        }
        Long imageHeight = null;
        if (image != null) {
            imageHeight = (long) image.getHeight();
        }

        List<Image> images = imageService.ImageRandom(ImageConstant.IMAGECX,ImageConstant.IMAGECY,imageWidth,imageHeight);

        return ResultUtils.success(images);
    }

}
