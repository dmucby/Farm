package com.boyu.farmsharing.model.request.FarmPost;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserOwnerPostGetList implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 用户openId
     */
    private String openId;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 页中个数
     */
    private Integer pageNums;
}
