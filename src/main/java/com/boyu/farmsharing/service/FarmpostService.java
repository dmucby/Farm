package com.boyu.farmsharing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boyu.farmsharing.model.domain.Farmpost;

import java.util.List;


/**
* @author 余悸
* @description 针对表【farmpost(帖子)】的数据库操作Service
* @createDate 2022-06-13 19:35:52
*/
public interface FarmpostService extends IService<Farmpost> {
    /**
     * 发布文章
     * @param postTitle 文章名
     * @param postContent 文章内容
     * @param userName 文章作者
     */
    Boolean userPost(String postTitle,String postContent,String userName,String postPicture,String openId);

    /**
     * 分页返回
     * @param pageNumber 页码
     * @param pageNums 页面内容个数
     */
    List<Farmpost> postPage(Integer pageNumber, Integer pageNums,String matchField);

    /**
     * 分页返回
     * @param pageNumber 页码
     * @param pageNums 页面内容个数
     */
    List<Farmpost> userPostPage(Integer pageNumber, Integer pageNums,String openId);

}
