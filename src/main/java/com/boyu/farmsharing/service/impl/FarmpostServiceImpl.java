package com.boyu.farmsharing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.boyu.farmsharing.mapper.FarmPostMapper;
import com.boyu.farmsharing.model.domain.Farmpost;
import com.boyu.farmsharing.service.FarmpostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
* @author 余悸
* @description 针对表【farmpost(帖子)】的数据库操作Service实现
* @createDate 2022-06-13 19:35:52
*/

@Service
public class FarmpostServiceImpl extends ServiceImpl<FarmPostMapper, Farmpost>
    implements FarmpostService {

    @Override
    public Boolean userPost(String postTitle, String postContent, String userName,String postPicture ) {
        /**
         * 1.校验
         */
        if(StringUtils.isAnyBlank(postTitle,postContent,userName)){
            return false;
        }

        /**
         * 2.插入数据库中
         */
        Farmpost farmpost = new Farmpost();
        farmpost.setPostTitle(postTitle);
        farmpost.setPostContent(postContent);
        farmpost.setUserName(userName);

        farmpost.setPostPicture(postPicture);

        farmpost.setUserID(UUID.randomUUID().variant());
        farmpost.setCreateDate(new Date());

        Random random = new Random();
        farmpost.setPostLove(random.nextInt(300));
        farmpost.setPostReading(random.nextInt(500));

        return this.save(farmpost);
    }
}




