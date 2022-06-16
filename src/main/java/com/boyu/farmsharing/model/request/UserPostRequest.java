package com.boyu.farmsharing.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPostRequest implements Serializable {
    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 文章标题
     */
    String postTitle;

    /**
     * 文章内容
     */
    String postContent;

    /**
     * 文章图片
     */
    String postPicture;

    /**
     * 用户名
     */
    String userName;


}
