package com.boyu.farmsharing.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPostGetRequest implements Serializable {
    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 文章ID
     */
    private Integer PostID;
}
