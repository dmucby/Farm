package com.boyu.farmsharing.model.request.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOpenIdRequest implements Serializable {
    /**
     * 获取用户openId的连接
     */
    private String userUrl;

    private static final long serialVersionUID = 1231425435457575674L;
}
