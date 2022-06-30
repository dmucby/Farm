package com.boyu.farmsharing.model.request.FarmPost;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPostGetList implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 页中个数
     */
    private Integer pageNums;

    /**
     * 匹配字段
     *  匹配日期 CreateDate
     *  点赞数 PostLove
     */
    private String matchField;
}
