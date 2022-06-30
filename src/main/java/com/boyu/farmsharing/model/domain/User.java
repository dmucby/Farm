package com.boyu.farmsharing.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 微信openId
     */
    @TableId
    private String openId;

    /**
     * 微信用户名

     */
    private String username;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 用户更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}