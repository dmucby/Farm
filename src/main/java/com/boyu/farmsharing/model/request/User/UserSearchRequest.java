package com.boyu.farmsharing.model.request.User;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSearchRequest implements Serializable {

    private static final long serialVersionUID = 1231425435457575674L;

    /**
     * 搜索标题关键字
     */
    private String searchPostTitles;
}
