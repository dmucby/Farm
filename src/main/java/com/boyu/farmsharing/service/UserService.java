package com.boyu.farmsharing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boyu.farmsharing.model.domain.User;


/**
* @author 余悸
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-06-29 21:38:37
*/
public interface UserService extends IService<User> {

    /**
     * 将用户信息存入数据库
     * @param openId 微信ID
     * @param username 微信用户名
     * @param avatarUrl 微信头像
     * @return 成功或者失败
     */
    boolean userSave(String openId, String username,String avatarUrl);

    /**
     * 获取用户的openId
     * @param openIdUrl 用户的Url
     * @return 用户的openId
     */
    String userOpenId(String openIdUrl);

    /**
     * 判断请求参数是否为空
     * @param request 请求参数
     * @return 空 或者 不为空
     */
    boolean requestIsNull(Object request);

    /**
     * 去除返回值值中的openId
     * @param user 一个用户
     * @return 没有openId的用户
     */
    User cleanUser(User user);

    /**
     * 用户鉴权
     * @param openId 用户openId
     * @return 是否登录
     */
    boolean userIsSave(String openId);

    /**
     * 判断用户是否重复登陆
     * @param openId 用户openId
     * @return 是否重复登录
     */
    boolean userIsLogin(String openId);

}
