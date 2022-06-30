package com.boyu.farmsharing.model.request.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 可选更新
     * 1. 用户昵称
     * 2. 用户头像
     */
    private String stringKey;

    /**
     * 键值对值
     */
    private String stringValue;

    /**
     * 用户Id
     */
    private String openId;
}
