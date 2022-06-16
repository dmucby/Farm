package com.boyu.farmsharing.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子
 * @TableName farmpost
 */
@TableName(value ="farmpost")
@Data
public class Farmpost implements Serializable {
    /**
     * 帖子ID
     */
    @TableId(value = "PostID", type = IdType.AUTO)
    private Integer postID;

    /**
     * 帖子标题
     */
    @TableField(value = "PostTitle")
    private String postTitle;

    /**
     * 帖子内容
     */
    @TableField(value = "PostContent")
    private String postContent;

    /**
     * 帖子图片连接
     */
    @TableField(value = "PostPicture")
    private String postPicture;

    /**
     * 发帖时间
     */
    @TableField(value = "CreateDate")
    private Date createDate;

    /**
     * 用户ID
     */
    @TableField(value = "UserID")
    private Integer userID;

    /**
     * 用户名
     */
    @TableField(value = "UserName")
    private String userName;

    /**
     * 阅读量
     */
    @TableField(value = "PostReading")
    private Integer postReading;

    /**
     * 点赞数
     */
    @TableField(value = "PostLove")
    private Integer postLove;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}