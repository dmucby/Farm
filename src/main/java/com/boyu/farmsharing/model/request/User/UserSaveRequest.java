package com.boyu.farmsharing.model.request.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSaveRequest implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 用户OpenId
     */
    private String openId;
}
