package com.boyu.farmsharing.model.request.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAdminRequest implements Serializable {
    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 鉴权所用OpenId
     */
    private String openId;
}
